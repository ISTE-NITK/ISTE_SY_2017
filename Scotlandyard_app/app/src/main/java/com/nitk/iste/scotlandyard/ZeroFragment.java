package com.nitk.iste.scotlandyard;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ZeroFragment extends Fragment implements TabsActivity.OnBackPressedListener {

    boolean referesh=false;

    HomeUserInfoFragment userProInfoFragment;
    ArrayList<AppointmentItemStub> items = new ArrayList<>();
    String storyunlock;

    View userInfoFragment;
    ArrayAdapter adapter = null;
    boolean showPlaceholder = false;
    ListView listview = null;
    private SwipeRefreshLayout swipeContainer;

    int profileFragmentHeight = 0;

    @Override
    public void onDetach() {
        super.onDetach();
        try {
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items = new ArrayList<>();

        /*getData();*/

        adapter = new AppointmentItemAdapter(getActivity(), R.layout.daily_view_hour, items);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_daily_agenda, container, false);
        listview = (ListView) rootView.findViewById(R.id.listview);
        swipeContainer = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                referesh=true;
                items.clear();
                items.addAll(buildItems());

                if(referesh)
                    swipeContainer.setRefreshing(referesh=false);

                adapter = new AppointmentItemAdapter(getActivity(), R.layout.daily_view_hour, items);
                listview.setAdapter(adapter);
            }
        });

        items.clear();
        items.addAll(buildItems());
        if(referesh)
            swipeContainer.setRefreshing(referesh=false);
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        Log.d(getTag(), "Fragments: " + (getChildFragmentManager().getFragments() != null
                ? getChildFragmentManager().getFragments().size() : 0));
        userProInfoFragment = HomeUserInfoFragment.newInstance();
        profileFragmentHeight = (int) getResources().getDimension(R.dimen.header_height);

        getChildFragmentManager().beginTransaction()
                .replace(R.id.user_info_fragment, userProInfoFragment)
                .commit();

        userInfoFragment = rootView.findViewById(R.id.user_info_fragment);

        if (Build.VERSION.SDK_INT >= 11) {
            listview.setOnScrollListener(new AbsListView.OnScrollListener() {

                @Override
                public void onScrollStateChanged(AbsListView absListView, int i) {

                }

                @Override
                public void onScroll(AbsListView absListView, int firstVisibleItem,
                                     int visibleItemCount, int totalItemCount) {
                }
            });
        }

        LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.list_animation);
        listview.setLayoutAnimation(controller);

        listview.setAdapter(adapter);
        return rootView;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Restore preferences
        //        items.clear();
        //        items.addAll(buildItems()); // allow user to change day
        //        adapter.notifyDataSetChanged();
    }


    /*public String getNextRoutineHour() {
        int now = DateTime.now().getHourOfDay();
        for (Routine r : Routine.findAll()) {
            if (r.time().getHourOfDay() >= now) {
                return r.time().toString("kk:mm");
            }
        }
        return "00:00";
    }*/

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.d(getTag(), "Visible to user");
            //            if (profileShown)
            //                ((HomeActivity) getActivity()).setCustomTitle("MedCon");
            //            else
            //                ((HomeActivity) getActivity()).setCustomTitle(Session.instance().getUser().getName());
        }
    }

    public ArrayList<AppointmentItemStub> buildItems() {
        showPlaceholder = false;
        ArrayList<AppointmentItemStub> items = new ArrayList<AppointmentItemStub>();
        listview.setAdapter(adapter);
        String filename = "storyunlocked";
        SharedPreferences story;
        story = getContext().getSharedPreferences(filename, 0);
        storyunlock = story.getString("storyunlocked", "");
        if(!storyunlock.isEmpty()) {
            items.add(new AppointmentItemStub(storyunlock, "Story "+ String.valueOf((char) (64+Integer.parseInt(storyunlock))), getDesc(Integer.parseInt(storyunlock)), getCluesUnlocked(), "Click to view progress (Pull down to refresh)"));
        }

        if (items.size() == 0) {
            showPlaceholder = true;
            addEmptyPlaceholder(items);
        }

        return items;
    }

    String getCluesUnlocked(){
        String filename = "Progress";
        String c1,c2,c3,c4,c5;
        String CluesUnlocked = "Clues Unlocked - preface";
        SharedPreferences Prog;
        Prog=getContext().getSharedPreferences(filename, 0);
        c1=Prog.getString("clue1","Yet to unlock");
        c2=Prog.getString("clue2","Yet to unlock");
        c3=Prog.getString("clue3","Yet to unlock");
        c4=Prog.getString("clue4","Yet to unlock");
        c5=Prog.getString("clue5","Yet to unlock");
        if(!c1.equalsIgnoreCase("Yet to unlock") )
            CluesUnlocked=CluesUnlocked.concat(", 1");
        if(!c2.equalsIgnoreCase("Yet to unlock") )
            CluesUnlocked=CluesUnlocked.concat(", 2");
        if(!c3.equalsIgnoreCase("Yet to unlock") )
            CluesUnlocked=CluesUnlocked.concat(", 3");
        if(!c4.equalsIgnoreCase("Yet to unlock") )
            CluesUnlocked=CluesUnlocked.concat(", 4");
        if(!c5.equalsIgnoreCase("Yet to unlock") )
            CluesUnlocked=CluesUnlocked.concat(", 5");

        return CluesUnlocked;
    }

    String getDesc(int story){
        switch (story){
            case 1: return "Where is the birthday boy?";
            case 2: return "Kidnapping Blues";
            case 3: return "Banana Stand";
            case 4: return "Fire at Ochaya";
            case 5: return "Peanut and the Poison";
            case 6: return "Murder at Fleet Street";
            case 7: return "The Death In The Family";
            case 8: return "The Mundane Murder";
            case 9: return "The Bloody Sunday";
            case 10: return "The Missing Pearls";
            case 11: return "Mystery of the Missing Cake";
            default: return "";
        }

    }
    private void addEmptyPlaceholder(ArrayList<AppointmentItemStub> items) {
        AppointmentItemStub spacer = new AppointmentItemStub();
        spacer.isEmptyPlaceholder = true;
        items.add(spacer);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public boolean doBack() {

        return true;
    }


    private View getAppointmentItemView(int position, View convertView, ViewGroup parent) {

        final LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        final AppointmentItemStub item = items.get(position);

        View v;
        if (item.isSpacer) {
            v = layoutInflater.inflate(R.layout.daily_view_spacer, null);
        } else if (item.isEmptyPlaceholder) {
            v = layoutInflater.inflate(R.layout.daily_view_empty_placeholder, null);
        }else{
            v = layoutInflater.inflate(R.layout.appointment_list_view, null);
            View overlay = v.findViewById(R.id.appointment_list_item_container);

            ((TextView) v.findViewById(R.id.DoctorName)).setText(item.DoctorName);
            ((TextView) v.findViewById(R.id.AppointmentDate)).setText(item.AppointmentDate);
            ((TextView) v.findViewById(R.id.AppointmentDay)).setText(item.AppointmentDay);
            ((TextView) v.findViewById(R.id.AppointmentTime)).setText(item.AppointmentTime);
            overlay.setTag(item);
            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(getActivity(), DisplayStory.class);
                    i.putExtra("storytag",Integer.parseInt(storyunlock));
                    startActivity(i);

                }
            };

            overlay.setOnClickListener(clickListener);
            overlay.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    return true;
                }
            });
        }
        return v;
    }

    private class AppointmentItemAdapter extends ArrayAdapter<AppointmentItemStub> {

        public AppointmentItemAdapter(Context context, int layoutResourceId,
                                 ArrayList<AppointmentItemStub> items) {
            super(context, layoutResourceId, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getAppointmentItemView(position, convertView, parent);
        }
    }

}