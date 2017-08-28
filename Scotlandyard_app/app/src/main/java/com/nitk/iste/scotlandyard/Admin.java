package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Admin extends Activity implements OnClickListener {

	public static String filename = "admindata";
	Button b1;
	EditText et1,et2;
	TextView tv1;
	SharedPreferences admin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.admin);

		admin = getSharedPreferences(filename, 0);
		et1=(EditText)findViewById(R.id.passwordadmin);
		et2=(EditText)findViewById(R.id.admincomment);
		b1=(Button)findViewById(R.id.saveadmin);
		tv1=(TextView)findViewById(R.id.comment1);
		b1.setOnClickListener(this);
		String dataReturned = admin.getString("sharedString", "");
		tv1.setText(dataReturned);
	}
	@Override
	public void onClick(View arg0) {
		String pas,data;
		pas=et1.getText().toString();

		if(pas.compareTo("admin login")==0)
		{
			data=et2.getText().toString();
			SharedPreferences.Editor editor = admin.edit();
			editor.putString("sharedString", admin.getString("sharedString", "") + "\n" + data);
			editor.apply();
			Toast.makeText(getApplicationContext(), "Comments updated", Toast.LENGTH_LONG).show();
			finish();
		}
		else Toast.makeText(getApplicationContext(), "Incorrect password", Toast.LENGTH_LONG).show();

	}


}
