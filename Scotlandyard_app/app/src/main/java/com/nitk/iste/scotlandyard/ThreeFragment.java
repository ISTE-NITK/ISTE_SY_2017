package com.nitk.iste.scotlandyard;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.dial;


public class ThreeFragment extends Fragment{

    Button b1;

    public ThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        container.setBackgroundColor(getResources().getColor(R.color.white));
        View view = inflater.inflate(R.layout.help, container, false);
        b1=(Button)view.findViewById(R.id.devcontact);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent dial=new Intent(Intent.ACTION_DIAL);
                dial.setData(Uri.parse("tel:+919916611368"));
                startActivity(dial);

            }
        });
        return view;
    }

}
