package com.nitk.iste.scotlandyard;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.graphics.PointF;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.PointTarget;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;

import java.util.HashMap;


public class AppTutorial {

    public static final String WELCOME = "WELCOME";
    public static final String HOME_INFO = "HOME_INFO";
    public static final String FIND_INFO = "FIND_INFO";
    public static final String BLOG_INFO = "BLOG_INFO";
    public static final String NEWSFEED_INFO = "NEWSFEED_INFO";
    public static final String NOTIFICATION_INFO = "NOTIFICATION_INFO";
    private static final String TAG = "AppTutorial";
    ShowcaseView showcaseView;
    HashMap<String, ShowcaseInfo> stages = new HashMap<String, ShowcaseInfo>();

    boolean open = false;

    public void show(final String stage, Activity activity) {
        show(stage, -1, activity);

    }

    public void show(final String stage, int target, Activity activity) {

        Log.d(TAG, "Showing stage " + stage);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        final String preference_key = "tutorial_" + stage + "_shown";
        boolean stageShown = prefs.getBoolean(preference_key, false);

        if (!stageShown && stages.containsKey(stage)) {

            if (showcaseView != null) {
                showcaseView.setVisibility(View.GONE);
                showcaseView = null;
            }


            Log.d(TAG, "Creating showcase");

            final ShowcaseInfo info = stages.get(stage);

            Target t;

            if (target != -1) {
                t = new ViewTarget(target, activity);
            } else {
                t = info.target != null ? info.target : Target.NONE;
            }

            open = true;
            showcaseView = new ShowcaseView.Builder(activity, true)
                    .setTarget(t)
                    .setStyle(R.style.CustomShowcaseTheme)
                    .setContentTitle(info.title)
                    .setContentText(info.detail)
                    .setShowcaseEventListener(new OnShowcaseEventListener() {
                        @Override
                        public void onShowcaseViewHide(ShowcaseView showcaseView) {
                            prefs.edit().putBoolean(preference_key, true).commit();
                            open = false;
                            if (info.listener != null) {
                                Log.d(TAG, "Call listener onHide");
                                info.listener.onHide();
                            }
                        }

                        @Override
                        public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                        }

                        @Override
                        public void onShowcaseViewShow(ShowcaseView showcaseView) {

                        }
                    })
                    .build();
            showcaseView.show();
        } else {
            Log.d("AppTutorial", "Stage '" + stage + "' already shown!");
        }

    }


    public void show(final String firstStage, final String secondStage, final Activity activity) {

        Log.d(TAG, "Showing stages " + firstStage + " and " + secondStage);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        final String preference_key = "tutorial_" + firstStage + "_shown";
        boolean stageShown = prefs.getBoolean(preference_key, false);

        if (!stageShown && stages.containsKey(firstStage)) {

            if (showcaseView != null) {
                showcaseView.setVisibility(View.GONE);
                showcaseView = null;
            }


            final ShowcaseInfo info = stages.get(firstStage);

            open = true;
            showcaseView = new ShowcaseView.Builder(activity, true)
                    .setTarget(info.target != null ? info.target : Target.NONE)
                    .setStyle(R.style.CustomShowcaseTheme2)
                    .setContentTitle(info.title)
                    .setContentText(info.detail)
                    .setShowcaseEventListener(new OnShowcaseEventListener() {
                        @Override
                        public void onShowcaseViewHide(ShowcaseView showcaseView) {
                            prefs.edit().putBoolean(preference_key, true).commit();
                            open = false;
                            show(secondStage, activity);
                        }

                        @Override
                        public void onShowcaseViewDidHide(ShowcaseView showcaseView) {

                        }

                        @Override
                        public void onShowcaseViewShow(ShowcaseView showcaseView) {

                        }
                    })
                    .build();
            showcaseView.show();
        } else {
            Log.d("AppTutorial", "Stage '" + secondStage + "' already shown!");
        }

    }

    public void reset(Activity activity) {
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("tutorial_" + WELCOME + "_shown", false);
        editor.putBoolean("tutorial_" + HOME_INFO + "_shown", false);
        editor.putBoolean("tutorial_" + FIND_INFO + "_shown", false);
        editor.putBoolean("tutorial_" + BLOG_INFO + "_shown", false);
        editor.putBoolean("tutorial_" + NEWSFEED_INFO + "_shown", false);
        editor.putBoolean("tutorial_" + NOTIFICATION_INFO + "_shown", false);
        editor.commit();
    }


    public void hide() {
        if (showcaseView != null) {
            open = false;
            showcaseView.hide();
        }
    }

    public void init(final Activity activity) {


        PointF size = Screen.getDpSize(activity);
        int width = (int) (size.x * Screen.getDensity(activity));
        int height = (int) (size.y * Screen.getDensity(activity));
        int gap = width / 8;
        int pointY = gap * 2;

        PointTarget pth = new PointTarget(new Point(width / 2, height / 4));
        PointTarget pti = new PointTarget(new Point(gap * 7, height / 2 + height / 4));//+ width / 4
        PointTarget ptr = new PointTarget(new Point(gap * 3, pointY));
        PointTarget ptm = new PointTarget(new Point(gap * 5, pointY));
        PointTarget pts = new PointTarget(new Point(gap * 7, pointY));

        stages.put(WELCOME, new ShowcaseInfo(R.string.tutorial_welcome_title, R.string.tutorial_welcome_text, pth));

        //new ViewTarget()

        stages.put(HOME_INFO, new ShowcaseInfo(R.string.tutorial_homeinfo_title, R.string.tutorial_homeinfo_text, new PointTarget(new Point(gap, gap)), new ShowcaseListener() {
            @Override
            public void onHide() {
                if (activity instanceof TabsActivity) {
                    ((TabsActivity) activity).onNavigationItemSelected(1, 0);
                }
            }
        }));
        stages.put(FIND_INFO, new ShowcaseInfo(R.string.tutorial_find_title, R.string.tutorial_find_text, ptr, new ShowcaseListener() {
            @Override
            public void onHide() {
                if (activity instanceof TabsActivity) {
                    ((TabsActivity) activity).onNavigationItemSelected(2, 0);
                }
            }
        }));
        stages.put(BLOG_INFO, new ShowcaseInfo(R.string.tutorial_blog_title, R.string.tutorial_blog_text, ptm, new ShowcaseListener() {
            @Override
            public void onHide() {
                if (activity instanceof TabsActivity) {
                    ((TabsActivity) activity).onNavigationItemSelected(3, 0);
                }
            }
        }));
        stages.put(NEWSFEED_INFO, new ShowcaseInfo(R.string.tutorial_newsfeed_title, R.string.tutorial_newsfeed_text, pts, new ShowcaseListener() {
            @Override
            public void onHide() {
                if (activity instanceof TabsActivity) {
                    ((TabsActivity) activity).onNavigationItemSelected(0, 0);
                }
            }
        }));


    }

    public boolean isOpen() {
        return open;
    }

    private interface ShowcaseListener {
        void onHide();
    }


    private class ShowcaseInfo {
        public int title;
        public int detail;
        public Target target;
        public ShowcaseListener listener;
        public int theme = R.style.CustomShowcaseTheme2;

        public ShowcaseInfo(int title, int detail, Target target) {
            this.title = title;
            this.detail = detail;
            this.target = target;
        }

        public ShowcaseInfo(int title, int detail, Target target, ShowcaseListener l) {
            this.title = title;
            this.detail = detail;
            this.target = target;
            this.listener = l;
        }

        public ShowcaseInfo(int title, int detail, Target target, int theme) {
            this.title = title;
            this.detail = detail;
            this.target = target;
            this.theme = theme;
        }


    }


}
