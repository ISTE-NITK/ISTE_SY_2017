package com.nitk.iste.scotlandyard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.makeramen.RoundedImageView;


public class TabsActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, ActionBar.OnNavigationListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ScrimInsetsFrameLayout drawerView;
    ActionBarDrawerToggle mDrawerToggle;
    private AppTutorial tutorial;
    View tabsShadow;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.home_ic);
        // configure toolbar as action bar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        // initialize left drawer
        initializeDrawer();


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout ) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOnPageChangeListener(this);
        setupTabIcons();
        initializeDrawer();
        tabsShadow = findViewById(R.id.tabs_shadow);

        setTutorial(new AppTutorial());
        getTutorial().init(this);
        getTutorial().show(AppTutorial.WELCOME, AppTutorial.HOME_INFO, this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public AppTutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(AppTutorial tutorial) {
        this.tutorial = tutorial;
    }


    private void showTutorialStage(int step) {
        switch (step) {
            case 0:
                //Home
                getTutorial().show(AppTutorial.HOME_INFO, this);
                break;
            case 1:

                getTutorial().show(AppTutorial.FIND_INFO, this);
                break;
            case 2:

                getTutorial().show(AppTutorial.BLOG_INFO, this);
                break;
            case 3:

                getTutorial().show(AppTutorial.NEWSFEED_INFO, this);
                break;
            default:
                break;
        }
    }


    private void initializeDrawer() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer_list);
        drawerView = (ScrimInsetsFrameLayout) findViewById(R.id.left_drawer);

        List<String> items =
                Arrays.asList(getResources().getStringArray(R.array.home_drawer_actions));
        // Set the adapter for the list view
        mDrawerList.setAdapter(new DrawerListAdapter(getApplication(), R.layout.drawer_list_item, items));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    public int getActionDrawable(int index) {
        switch (index) {

            case 1:
                return R.drawable.ic_small_home_w;
            case 3:
                return R.drawable.stories;
            case 4:
                return R.drawable.rules;
            case 5:
                return R.drawable.help;
            case 7:
                return R.drawable.ic_security_white_48dp;
            case 8:
                return R.drawable.ic_room_white_48dp;
            default:
                return R.drawable.ic_small_home_w;
        }
    }

    public int getActionColor(int index) {
        switch (index) {
            case 3:
                return R.color.android_orange;
            case 4:
                return R.color.android_pink;
            case 5:
                return R.color.android_green;
            case 7:
                return R.color.android_blue_light;
            case 8:
                return R.color.android_red_light;
            default:
                return R.color.dark_grey_home;
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 123) {
            if (resultCode == 559) {
                this.finish();

            }
        }
    }

    public void selectItem(int position) {
        Log.d("Agenda", "Position :" + position);
        if (position == 1) {
            viewPager.setCurrentItem(0);
        } else if (position > 2 && position < 6) {
            viewPager.setCurrentItem(position - 2);
        } else if (position == 7) {
            startActivity(new Intent(this, Admin.class));
        } else if (position == 8) {
            startActivity(new Intent(this, OfflineMap.class));
        } else if (position == 9) {
            startActivityForResult(new Intent(this, ContactUs.class), 123);
        } else if (position == 10) {
            viewPager.setCurrentItem(0);
            getTutorial().reset(this);
            getTutorial().show(AppTutorial.WELCOME, AppTutorial.HOME_INFO, this);
        }

        mDrawerLayout.closeDrawer(drawerView);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Tabs Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.nitk.iste.scotlandyard/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Tabs Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.nitk.iste.scotlandyard/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    private void updateTitle(int page) {
        String title;

        switch (page) {
            case 1:
                title = "Stories";
                break;
            case 2:
                title ="Rules" ;
                break;
            case 3:
                title = "Help";
                break;
            default:
                title = "";
                break;
        }
        toolbar.setTitle(title);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onPageSelected(int page) {
        invalidateOptionsMenu();
        updateTitle(page);
        if (page == 0) {
            hideTabs();
        } else {

            if (toolbar.getVisibility() != View.VISIBLE) {
                toolbar.setVisibility(View.VISIBLE);
            }
            showTabs();
        }
    }



    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == 0) {
            hideTabs();
        } else {
            showTabs();
        }
    }


    public interface OnBackPressedListener {
        boolean doBack();
    }

    class DrawerListAdapter extends ArrayAdapter<String> {

        public DrawerListAdapter(Context context, int resource, List<String> items) {
            super(context, resource, items);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String item = getItem(position);

            final LayoutInflater layoutInflater = getLayoutInflater();

            if (item.equalsIgnoreCase(getString(R.string.drawer_top_option))) {

                SharedPreferences prefs =
                        PreferenceManager.getDefaultSharedPreferences(getContext());
                String displayName = prefs.getString("display_name", "Scotland Yard");

                View v = layoutInflater.inflate(R.layout.drawer_top, null);
                ((TextView) v.findViewById(R.id.text)).setText(displayName);

                return v;
            }
            if (item.equalsIgnoreCase(getString(R.string.drawer_bottom_option))) {
                View v = layoutInflater.inflate(R.layout.drawer_bottom, null);
                TextView help = ((TextView) v.findViewById(R.id.text_help));
                help.setText(getString(R.string.drawer_help_option));
                help.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectItem(10);
                    }
                });
                TextView settings = ((TextView) v.findViewById(R.id.text_settings));
                settings.setText(getString(R.string.drawer_settings_option));
                settings.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        selectItem(9);
                    }
                });
                return v;
            }
            if (item.equalsIgnoreCase(getString(R.string.drawer_menu_option))
                    || item.equalsIgnoreCase(getString(R.string.drawer_services_option))) {
                View v = layoutInflater.inflate(R.layout.drawer_list_item_spacer, null);
                ((TextView) v.findViewById(R.id.text)).setText(item);
                v.setEnabled(false);
                return v;
            } else {
                View v = layoutInflater.inflate(R.layout.drawer_list_item, null);
                ((TextView) v.findViewById(R.id.text)).setText(item);
                ((ImageView) v.findViewById(R.id.imageView)).setImageResource(
                        getActionDrawable(position));
                ((RoundedImageView) v.findViewById(R.id.imageViewbg)).setImageResource(
                        getActionColor(position));
                ((RoundedImageView) v.findViewById(R.id.imageViewbg)).mutateBackground(true);

                return v;
            }
        }

        @Override
        public boolean isEnabled(int position) {
            return (position != 0 && position != 2);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {

            selectItem(position);
        }
    }

    public boolean onNavigationItemSelected(int i, long l) {
        viewPager.setCurrentItem(i);
        showTutorialStage(i);
        return true;
    }

    /**
     * Adding custom view to tab
     */
    private void setupTabIcons() {

        TextView tabZero = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabZero.setText("Home");
        tabZero.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.home_ic, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabZero);

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Stories");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.stories, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Rules");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.rules, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Help");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.help, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabThree);

    }

    public void hideToolbar() {
        toolbar.setVisibility(View.GONE);
    }

    public void showToolbar() {
        toolbar.setVisibility(View.VISIBLE);
    }

    public void showTabs() {
        if (!(tabLayout.getVisibility() == View.VISIBLE)) {
            tabLayout.setVisibility(View.VISIBLE);
            //tabsShadow.setVisibility(View.VISIBLE);
        }
    }

    public void hideTabs() {
        if (!(tabLayout.getVisibility() == View.GONE)) {
            tabLayout.setVisibility(View.GONE);
            //tabsShadow.setVisibility(View.GONE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.transparent));
            }
        }
    }

    /**
     * Adding fragments to ViewPager
     *
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new ZeroFragment(), "ZERO");
        adapter.addFrag(new OneFragment(), "ONE");
        adapter.addFrag(new TwoFragment(), "TWO");
        adapter.addFrag(new ThreeFragment(), "THREE");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
