package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class ShowProgress extends Activity {

	public static String filename = "Progress";
	SharedPreferences Prog;
	String preface,c1,c2,c3,c4,c5;
	TextView t1,t2,t3,t4,t5,t6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_progress);
		Prog=getSharedPreferences(filename, 0);
		preface = Prog.getString("preface", "Yet to unlock");
		c1=Prog.getString("clue1","Yet to unlock");
		c2=Prog.getString("clue2","Yet to unlock");
		c3=Prog.getString("clue3","Yet to unlock");
		c4=Prog.getString("clue4","Yet to unlock");
		c5=Prog.getString("clue5","Yet to unlock");
		t1=(TextView)findViewById(R.id.preface);
		t2=(TextView)findViewById(R.id.clue1);
		t3=(TextView)findViewById(R.id.clue2);
		t4=(TextView)findViewById(R.id.clue3);
		t5=(TextView)findViewById(R.id.clue4);
		t6=(TextView)findViewById(R.id.clue5);
		t1.setText(preface);
		t2.setText(c1);
		t3.setText(c2);
		t4.setText(c3);
		t5.setText(c4);
		t6.setText(c5);
		
	}
}
