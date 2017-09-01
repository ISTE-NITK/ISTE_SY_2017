package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Password extends Activity implements OnClickListener {

	Button b1;
	EditText et1;
	String storyunlocked,password;
	int tagvalue;
	static final String[] passwords = {
            "17dc336a955a4248b0f596b63681f16c",
            "ba29a0f170454848b4108d59d04c12b0",
            "f8065598ea6a40399565f6c96f20c375",
            "292388ef228c4b3cb2006ae6bc15f945",
            "cc0ee6c051c94f6ab7b9e3b41aa31d99",
            "1ee1c10892a0425eb244e49ad83338a8",
            "87925b229aa2484095a4b05386a89475",
            "87208a1154bc4206977835f7efb73ea0",
            "2abb657cafc347409abff13e2cb2dbaf",
            "ea1e8a4765234423ac43188a5543c518",
            "032119198f0546ddac2e99662e9e0c1a",
            "4d4b2eb32108400ea771ad214f2cc7e2",
            "c2b78afaec8e475792034e8516faefd3",
            "aebf64f5ab5642b3b1e3fadfde6adcf6",
            "cb3385fdcf8b4596aadcf075dbbf317c"
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.password);
		Intent intent=getIntent();
		tagvalue= intent.getIntExtra("tag",1);
		storyunlocked=intent.getStringExtra("storyunlocked");

		b1=(Button)findViewById(R.id.storygo);
		et1=(EditText)findViewById(R.id.storypassword);
		b1.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		Intent i;
		password = et1.getText().toString();

        if(password.compareToIgnoreCase(passwords[tagvalue-1])==0) {
            i = new Intent(Password.this, DisplayStory.class);
            i.putExtra("storytag", tagvalue);
			SharedPreferences.Editor editor = OneFragment.story.edit();
			editor.putString("storyunlocked", storyunlocked);
			editor.apply();
			Toast.makeText(getApplicationContext(), "Story "+storyunlocked+" opened", Toast.LENGTH_SHORT).show();
            finish();
			startActivity(i);
        }

	    else Toast.makeText(Password.this, "Wrong password", Toast.LENGTH_SHORT).show();

	}
}
