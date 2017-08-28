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
            "OXteGmQbcHHkgcAgUD6AI",
            "0mCf8aUMAei1zKlpwTvBI",
            "AWBrXPF7dFgtl342JFP8J",
            "JRXRWS5BQGa3YEZwWgaNC",
            "wHkRHi8mEfQ4wsuO7gZE7",
            "umO8sB91DuSQZjwTEZg1N",
            "nVLsxFeksHTbknB1gyvZX",
            "R3BWRPHF7xjugDp9fLh6v",
            "i9kO9LEzOcIyz05WOdpOa",
            "J6R33XqLGgEQFijbO6zVk",
            "1tPdJqodkqEiHfDs3TCK8"
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
