package com.nitk.iste.scotlandyard;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QRScanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    public static String filename = "Progress";
    String pass,password;
    int tagvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QrScanner();
    }

    public void QrScanner(){


        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);

        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Start camera

    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

        Log.e("handler", rawResult.getText()); // Prints scan results
        Log.e("handler", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)

        // show the scanner result into dialog box.
        //rawResult.getText();
        Intent intent=getIntent();
        tagvalue=intent.getIntExtra("cluetag", 0);
        if(tagvalue !=0) {
            SharedPreferences Prog;
            Prog = getSharedPreferences(filename, 0);
            SharedPreferences.Editor editor = Prog.edit();
            pass = rawResult.getText();
            int index = tagvalue - (11 + (tagvalue / 10 - 1) * 5);
            String tagnames[] = {"", "clue1", "clue2", "clue3", "clue4", "clue5"};

            if (pass.contentEquals(PasswordTwo.st[index])) {
                editor.putString(tagnames[tagvalue % 10], PasswordTwo.clues[index]);
                Toast.makeText(getApplicationContext(), "Story segment unlocked", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Oops! match not found.", Toast.LENGTH_LONG).show();
                finish();
            }
            editor.apply();
        }
        else
        {
            Intent i;
            password = rawResult.getText();
            tagvalue= intent.getIntExtra("tag",1);
            String storyunlocked=intent.getStringExtra("storyunlocked");
            if(password.compareToIgnoreCase(Password.passwords[tagvalue-1])==0) {
                i = new Intent(QRScanner.this, DisplayStory.class);
                i.putExtra("storytag", tagvalue);
                SharedPreferences.Editor editor = OneFragment.story.edit();
                editor.putString("storyunlocked", storyunlocked);
                editor.apply();
                Toast.makeText(getApplicationContext(), "Story "+storyunlocked+" opened", Toast.LENGTH_SHORT).show();
                finish();
                startActivity(i);
            }

            else Toast.makeText(QRScanner.this, "Oops! That's not for this story.", Toast.LENGTH_SHORT).show();
            finish();

        }
        // If you would like to resume scanning, call this method below:
        // mScannerView.resumeCameraPreview(this);
    }
}
