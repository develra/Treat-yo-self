package com.example.treat_yo_self;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.os.Build;
import android.content.Intent;
import android.os.Bundle;

public class PostWelcomeActivity extends Activity {
	private final int SPLASH_DISPLAY_SECONDS = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

	    //set content view AFTER ABOVE sequence (to avoid crash)
		setContentView(R.layout.activity_post_welcome);
		/* New Handler to go to the landing page 
	     * and close the welcome screen after some seconds.*/
	    new Handler().postDelayed(new Runnable() {
	        @Override
	        public void run() {
	            /* Create an Intent that will go to the landing page. */
	            Intent mainIntent = new Intent(PostWelcomeActivity.this, TasksActivity.class);
	            PostWelcomeActivity.this.startActivity(mainIntent);
	            PostWelcomeActivity.this.finish();
	        }
	    }, SPLASH_DISPLAY_SECONDS * 1000);
	}

}
