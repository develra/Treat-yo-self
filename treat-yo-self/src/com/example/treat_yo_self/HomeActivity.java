package com.example.treat_yo_self;

import com.example.treat_yo_self.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 * 
 * @see SystemUiHider
 */
public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		//NEED TO FIX IMAGE BUTTON CANNOT BE TYPE OF BUTTON
		
//		Button treatyoself = (Button) findViewById(R.id.home_treatyoself);
//		/**
//		 * when click treat your self
//		 */
//		treatyoself.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				//CHANGE IT TO TREAT PAGE
//				Intent treatYoselfIntent = new Intent(
//						getApplicationContext(), TasksActivity.class);
//				startActivity(treatYoselfIntent);
//			}
//		});

		/*
		 * This little area of code is a bit weird. Basically, we have a list
		 * view that starts out empty. What we're doing here is getting an array
		 * of Strings (that represent the task) and populating the list view
		 * by putting our array into an array adaptor, and then setting that
		 * adaptor to our list view.
		 */
//		ListView list = (ListView) findViewById(R.id.home_tasklist);
//		// DB STUFF GOES HERE NEED A LIST FOR TASK
//		String[] tasksList = null;
//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//				getApplicationContext(), R.layout.task_list, tasksList);
//		list.setAdapter(adapter);
//
//		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View viewClicked,
//					int position, long id) {
//				//DB STUFF GOES HERE!!
//				Intent taskIntent = new Intent(getApplicationContext(),
//						Task.class);
//				startActivity(taskIntent);
//			}
//
//		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	/*
	 * This basically forces the method to refresh, so when we back out of
	 * it calls onCreate() again and displays our new list
	 * list.
	 */
	@Override
	protected void onResume() {
		super.onResume();
		this.onCreate(null);

	}
}
