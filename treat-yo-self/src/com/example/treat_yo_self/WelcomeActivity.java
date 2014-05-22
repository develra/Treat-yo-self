package com.example.treat_yo_self;

import com.example.treat_yo_self.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.*;

import android.content.Intent;
import android.os.Bundle;

/**
 * The Class Welcome.
 * 
 * This is the first activity, or screen, for our android application.
 * 
 * @see SystemUiHider
 */
public class WelcomeActivity extends Activity {
	/**
	 * Whether or not the system UI should be auto-hidden after
	 * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
	 */
	private static final boolean AUTO_HIDE = true;

	private final int SPLASH_DISPLAY_SECONDS = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	    //set content view AFTER ABOVE sequence (to avoid crash)
		setContentView(R.layout.activity_welcome);

		/* New Handler to go to the landing page 
	     * and close the welcome screen after some seconds.*/
	    new Handler().postDelayed(new Runnable() {
	        @Override
	        public void run() {
	            /* Create an Intent that will go to the landing page. */
	            Intent mainIntent = new Intent(WelcomeActivity.this, PostWelcomeActivity.class);
	            WelcomeActivity.this.startActivity(mainIntent);
	            WelcomeActivity.this.finish();
	        }
	    }, SPLASH_DISPLAY_SECONDS * 1000);
	
	}
	
}
