package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ContactUs extends Activity implements OnClickListener {

	Button b1,b2,b3,b4,b5,b6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		b1=(Button)findViewById(R.id.bcontact1);
		b2=(Button)findViewById(R.id.bcontact2);
		b3=(Button)findViewById(R.id.bcontact3);
		b4=(Button)findViewById(R.id.bcontact4);
		b5=(Button)findViewById(R.id.bcontact5);
		b6=(Button)findViewById(R.id.bcontact6);
		b1.setOnClickListener(this);
		b2.setOnClickListener(this);
		b3.setOnClickListener(this);
		b4.setOnClickListener(this);
		b5.setOnClickListener(this);
		b6.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		Intent dial=new Intent(Intent.ACTION_DIAL);
		// TODO Auto-generated method stub
		switch(arg0.getId()){
            case R.id.bcontact1:dial.setData(Uri.parse("tel:+919071987791"));startActivity(dial);break;
            case R.id.bcontact2:dial.setData(Uri.parse("tel:+918095908965"));startActivity(dial);break;
            case R.id.bcontact3:dial.setData(Uri.parse("tel:+919600854611"));startActivity(dial);break;
            case R.id.bcontact4:dial.setData(Uri.parse("tel:+919028767233"));startActivity(dial);break;
            case R.id.bcontact5:dial.setData(Uri.parse("tel:+918105329305"));startActivity(dial);break;
            case R.id.bcontact6:dial.setData(Uri.parse("tel:+919916410370"));startActivity(dial);break;
		}
	}
	
	
}
