package com.nitk.iste.scotlandyard;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Start activity:
 * <p/>
 * - Show splash
 * - Check if session is open and forward user to home screen
 * - If not
 * - Try to resume session
 * - If success, forward user to home screen
 * - Else, redirect to login screen
 */
public class MainActivity extends AppCompatActivity {

    ImageView brand;
    TextView quote;
    ImageView splashLogo;

    public static final String STATUS_SESSION_OPEN = "STATUS_SESSION_OPEN";
    public static final String STATUS_SESSION_RESUMED = "STATUS_SESSION_RESUMED";
    public static final String STATUS_NO_SESSION = "STATUS_NO_SESSION";
    public static final int ACTION_DEFAULT = 1;
    public static final int ACTION_SHOW_REMINDERS = 2;


    int action = ACTION_DEFAULT;
    boolean mustShowSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        action = getIntent().getIntExtra("action", ACTION_DEFAULT);
        new UserResumeSessionTask().execute((Void) null);
        mustShowSplash = mustShowSplashForAction(action);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.activity_background_color));
        }

        if (mustShowSplash) {
            startAnimations();
        }
        //        if(PopulatePrescriptionDBService.needUpdate(getApplicationContext())) {
        //            PopulatePrescriptionDBService.updateIfNeeded(getApplicationContext());
        //        }
    }

    private boolean mustShowSplashForAction(int action)
    {
        return true;//!(action == ACTION_DELAY_ROUTINE || action == ACTION_CANCEL_ROUTINE);
    }

    private void startAnimations() {

        RotateAnimation rotateAnim = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim.setInterpolator(new LinearInterpolator());
        rotateAnim.setRepeatCount(Animation.INFINITE);
        rotateAnim.setFillAfter(true);
        rotateAnim.setDuration(4000);

        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(1000);

        AnimationSet animation = new AnimationSet(false); //change to false
        animation.addAnimation(fadeIn);
        animation.addAnimation(rotateAnim);

        // Start animating the image
        splashLogo = (ImageView) findViewById(R.id.splash_logo);
        splashLogo.startAnimation(animation);

        brand = (ImageView) findViewById(R.id.splash_brand);
        quote = (TextView) findViewById(R.id.splash_quote);
        Animation brandFaceIn = new AlphaAnimation(0, 1);
        brandFaceIn.setInterpolator(new DecelerateInterpolator());
        brandFaceIn.setStartOffset(500);
        brandFaceIn.setDuration(1000);
        brand.startAnimation(brandFaceIn);
        quote.startAnimation(brandFaceIn);
    }

    private void stopAnimations() {
        brand.clearAnimation();
        splashLogo.clearAnimation();
    }

    @Override
    public void onBackPressed() {
        // do nothing
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */

    public class UserResumeSessionTask extends AsyncTask<Void, Void, String> {

        boolean sessionIsOpen;


        private void keepSplashVisible(int seconds) {
            // Show splash
            try
            {
                if (action == ACTION_DEFAULT)
                {
                    Thread.sleep(seconds * 2500);
                }
            } catch (InterruptedException e)
            {
                // do nothing
            }
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params)
        {

            return STATUS_NO_SESSION;
        }

        @Override
        protected void onPostExecute(final String result)
        {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(MainActivity.this, StartStory.class);
                    startActivity(intent);
                    finish();
                }
            }, 4000);

        }

        @Override
        protected void onCancelled()
        {

        }
    }

}
