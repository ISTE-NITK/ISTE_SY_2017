package com.nitk.iste.scotlandyard;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import static android.content.ContentValues.TAG;
import static android.media.MediaRecorder.VideoSource.CAMERA;

public class UnlockType extends Activity implements OnClickListener {

    Button b1,b2;
    Intent unlock;
    int buttonClick;
    String storyunlocked;
    int tagvalue;
    int cluetag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        b1=(Button)findViewById(R.id.bunlock1);
        b2=(Button)findViewById(R.id.bunlock2);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

    }

    protected void makeRequest() {
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA);
    }

    @Override
    public void onClick(View arg0) {

        // TODO Auto-generated method stub
        Intent intent=getIntent();
        cluetag=intent.getIntExtra("cluetag", 0);
        if(cluetag !=0) {
            switch (arg0.getId()) {
                case R.id.bunlock1:
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED){
                        buttonClick=1;
                        makeRequest();
                    } else {
                        unlock = new Intent(this, QRScanner.class);
                        unlock.putExtra("cluetag", cluetag);
                        startActivity(unlock);
                        finish();
                    }
                    break;
                case R.id.bunlock2:
                    unlock = new Intent(this, PasswordTwo.class);
                    unlock.putExtra("cluetag", cluetag);
                    startActivity(unlock);
                    finish();
                    break;
                default:
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED){
                        buttonClick=1;
                        makeRequest();
                    } else {
                        unlock = new Intent(this, QRScanner.class);
                        unlock.putExtra("cluetag", cluetag);
                        startActivity(unlock);
                        finish();
                    }
            }

        }
        else{
            tagvalue= intent.getIntExtra("tag",1);
            storyunlocked=intent.getStringExtra("storyunlocked");
            switch (arg0.getId()) {
                case R.id.bunlock1:
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED){
                        buttonClick=2;
                        makeRequest();
                    } else {
                        unlock = new Intent(this, QRScanner.class);
                        unlock.putExtra("tag", tagvalue);
                        unlock.putExtra("storyunlocked", storyunlocked);
                        startActivity(unlock);
                        finish();
                    }  break;
                case R.id.bunlock2:
                    unlock = new Intent(this, Password.class);
                    unlock.putExtra("tag", tagvalue);
                    unlock.putExtra("storyunlocked", storyunlocked);
                    startActivity(unlock);
                    finish();
                    break;
                default:
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                            == PackageManager.PERMISSION_DENIED){
                        buttonClick=2;
                        makeRequest();
                    } else {
                        unlock = new Intent(this, QRScanner.class);
                        unlock.putExtra("tag", tagvalue);
                        unlock.putExtra("storyunlocked", storyunlocked);
                        startActivity(unlock);
                        finish();
                    }
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CAMERA: {

                if (grantResults.length == 0
                        || grantResults[0] !=
                        PackageManager.PERMISSION_GRANTED) {

                    Log.i(TAG, "Permission has been denied by user");
                    Toast.makeText(getApplicationContext(), "Camera access denied for QR scanner", Toast.LENGTH_LONG).show();

                    if(buttonClick==1){
                        unlock = new Intent(this, PasswordTwo.class);
                        unlock.putExtra("cluetag", cluetag);
                        startActivity(unlock);
                        finish();
                    }
                    else {
                        unlock = new Intent(this, PasswordTwo.class);
                        unlock.putExtra("tag", tagvalue);
                        unlock.putExtra("storyunlocked", storyunlocked);
                        startActivity(unlock);
                        finish();
                    }

                } else {
                    Log.i(TAG, "Permission has been granted by user");
                    unlock = new Intent(this, QRScanner.class);
                    if(buttonClick==1){
                        unlock.putExtra("cluetag", cluetag);
                        startActivity(unlock);
                        finish();
                    }
                    else {
                        unlock.putExtra("tag", tagvalue);
                        unlock.putExtra("storyunlocked", storyunlocked);
                        startActivity(unlock);
                        finish();
                    }
                }
                return;
            }
        }
    }

}
