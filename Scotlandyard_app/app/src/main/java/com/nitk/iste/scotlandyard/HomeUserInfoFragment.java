package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.makeramen.RoundedImageView;

import org.joda.time.DateTime;

/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 */
public class HomeUserInfoFragment extends Fragment {


    public SharedPreferences mSharedPreferences;
    ImageSwitcher background;
    View profileImageContainer;
    TextView profileUsername;
    // Listener defined by anonymous inner class.
    public SharedPreferences.OnSharedPreferenceChangeListener mListener = new SharedPreferences.OnSharedPreferenceChangeListener() {

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if ("display_name".equals(key) && profileUsername != null) {
                profileUsername.setText(mSharedPreferences.getString("display_name", "Scotland Yard"));
            }
        }
    };
    RelativeLayout profileContainer;
    CustomDigitalClock clock;
    TextView monthTv;
    TextView dayTv;
    ImageView moodImg;
    RoundedImageView modFabButton;
    ListAdapter moodsAdapter;
    String[] moods;

    int currentBgFileIdx = 0;

    public HomeUserInfoFragment() {

    }

    public static HomeUserInfoFragment newInstance() {
        return new HomeUserInfoFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_user_info, container, false);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        Animation in = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
        monthTv = (TextView) view.findViewById(R.id.month_text);
        dayTv = (TextView) view.findViewById(R.id.day_text);
        clock = (CustomDigitalClock) view.findViewById(R.id.home_clock);

        profileUsername = (TextView) view.findViewById(R.id.profile_username);
        profileContainer = (RelativeLayout) view.findViewById(R.id.profile_container);
        profileImageContainer = view.findViewById(R.id.profile_image_container);
        background = (ImageSwitcher) view.findViewById(R.id.image_switcher);
        background.setInAnimation(in);
        background.setOutAnimation(out);

        background.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                ImageView myView = new ImageView(getActivity());
                myView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(
                                ViewGroup.LayoutParams.FILL_PARENT,
                                ViewGroup.LayoutParams.FILL_PARENT)
                );
                return myView;
            }
        });

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateBackground();
            }
        });
        updateProfileInfo();


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        background.setImageDrawable(new BitmapDrawable(getBackgroundBitmap()));
    }

    public void updateBackground() {

        Bitmap b = getRandomBackground();
        background.setImageDrawable(new BitmapDrawable(b));

//        Palette.generateAsync(b, new Palette.PaletteAsyncListener() {
//            public void onGenerated(Palette palette) {
//                Palette.Swatch swatch = palette.getDarkVibrantSwatch();
//                int color;
//                if (swatch != null) {
//                    color = getResources().getColor(R.color.white);
//                }else{
//                    color = getResources().getColor(R.color.darker_blue);
//                }
//
//                profileUsername.setTextColor(color);
//                monthTv.setTextColor(color);
//                dayTv.setTextColor(color);
//                clock.setTextColor(color);
//
//            }
//        });
    }

    void updateProfileInfo() {

        String displayName = mSharedPreferences.getString("display_name", "Scotland Yard");
        profileUsername.setText(displayName);


        DateTime dt = DateTime.now();

        String dayStr = dt.dayOfMonth().getAsShortText();
        String monthStr = dt.monthOfYear().getAsShortText().toUpperCase();

        dayTv.setText(dayStr);
        monthTv.setText(monthStr);
    }

    Bitmap getBackgroundBitmap() {
        int width = (int) Screen.getDpSize(getActivity()).x;
        int height = getResources().getDimensionPixelSize(R.dimen.header_height);
        Integer idx = mSharedPreferences.getInt("profile_background_idx", 1);
        return Screen.getResizedBitmap(getActivity(), "home_bg_" + idx + ".jpg", width, height);
    }

    Bitmap getRandomBackground() {
        int width = (int) Screen.getDpSize(getActivity()).x;
        int height = getResources().getDimensionPixelSize(R.dimen.header_height);
        int rand = (((int) (Math.random() * 1000)) % 5) + 1;
        if (rand == currentBgFileIdx) {
            rand = ((rand + 1) % 5) + 1;
        }
        currentBgFileIdx = rand;

        mSharedPreferences.edit().putInt("profile_background_idx", rand).commit();

        return Screen.getResizedBitmap(getActivity(), "home_bg_" + rand + ".jpg", width, height);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mSharedPreferences.registerOnSharedPreferenceChangeListener(mListener);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSharedPreferences.unregisterOnSharedPreferenceChangeListener(mListener);
    }


}
