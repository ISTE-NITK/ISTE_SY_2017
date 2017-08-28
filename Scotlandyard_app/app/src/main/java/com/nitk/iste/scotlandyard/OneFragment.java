package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class OneFragment extends Fragment {

    ListView  listview;
    List<ItemObject> allItems;
    public static String filename = "storyunlocked";
    String dataReturned;
    public static SharedPreferences story;



    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        story = getContext().getSharedPreferences(filename, 0);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        container.setBackgroundColor(getResources().getColor(R.color.white));
        final View view = inflater.inflate(R.layout.stories , container, false);
        listview = (ListView) view.findViewById(R.id.listview);
        allItems=new ArrayList<>();
        allItems.add(new ItemObject(R.drawable.story_clue,"Story A", "Where is the birthday boy?"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story B", "Kidnapping Blues"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story C", "Banana Stand"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story D", "Fire at Ochaya"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story E", "Peanut and the Poison"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story F", "Murder at Fleet Street"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story G", "The Death In The Family"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story H", "The Mundane Murder"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story I", "The Bloody Sunday"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story J", "The Missing Pearls"));
        allItems.add(new ItemObject(R.drawable.story_clue,"Story K", "Mystery of the Missing Cake"));

        CustomAdapter customAdapter = new CustomAdapter(getContext(), allItems);
        listview.setAdapter(customAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dataReturned = story.getString("storyunlocked", "");
                if (dataReturned.equals("")) {
                    Intent intent = new Intent(getActivity(), UnlockType.class);
                    intent.putExtra("tag", position + 1);
                    intent.putExtra("storyunlocked", String.valueOf(position + 1));
                    startActivity(intent);
                }
                else if (dataReturned.equals( String.valueOf(position + 1))){
                    Intent i = new Intent(getActivity(), DisplayStory.class);
                    i.putExtra("storytag", position + 1);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getContext(), "Sorry, You can access only story " + String.valueOf((char) (64+Integer.parseInt(dataReturned))), Toast.LENGTH_SHORT).show();

                }
                //Toast.makeText(getBaseContext(), "Position: " + position, Toast.LENGTH_LONG).show();
                //Log.d("clicked", String.valueOf(position));
            }
        });

        return view;
    }

}
