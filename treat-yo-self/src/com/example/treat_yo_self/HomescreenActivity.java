package com.example.treat_yo_self;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class HomescreenActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homescreen);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.homescreen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle action bar item clicks here. The action bar will
	    // automatically handle clicks on the Home/Up button, so long
	    // as you specify a parent activity in AndroidManifest.xml.
	    int id = item.getItemId();
	    if (id == R.id.action_settings) {
	            return true;
	    } else if (id == R.id.action_taskpage) {
	            Intent intent = new Intent(this, TasksActivity.class);
	            startActivity(intent);
	            return true;
	    } else if (id == R.id.action_deposit) {
	            Intent intent = new Intent(this, DepositActivity.class);
	            startActivity(intent);
	            return true;
	    } else if (id == R.id.action_log_out) {
	            Intent intent = new Intent(this, LoginActivity.class);
	            startActivity(intent);
	            return true;
	    } else if (id == R.id.action_new_task) {
	            Intent intent = new Intent(this, NewTaskActivity.class);
	            startActivity(intent);
	            return true;
	    }
	    return super.onOptionsItemSelected(item);
	}


	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.activity_homescreen,
					container, false);
			return rootView;
		}
	}
	
	public void toTasks(View view) {
		Intent intent = new Intent(this, TasksActivity.class);
        startActivity(intent);
	}
	
	public void toDeposit(View view) {
		Intent intent = new Intent(this, DepositActivity.class);
        startActivity(intent);
	}
	
	public void toGoal(View view) {
		Intent intent = new Intent(this, GoalActivity.class);
        startActivity(intent);
	}

}
