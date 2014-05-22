package com.example.treat_yo_self;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.CheckBox;
import android.os.Handler;
import android.content.Intent;
import android.os.Bundle;

public class TasksActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tasks);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tasks, menu);
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
			View rootView = inflater.inflate(R.layout.activity_tasks,
					container, false);
			return rootView;
		}
	}
	
	private final int TASK_DELAY_SECONDS = 5;
	
	public void onCheckboxClicked(View view) {
	    // Is the view now checked?
	    boolean checked = ((CheckBox) view).isChecked();
	    
	    CheckBox box = (CheckBox) view;
	    // Check which checkbox was clicked
	    switch(view.getId()) {
	        case R.id.checkBox1:
	            if (checked) {
	            	//find and mark it in the database
	            	//find a new task and replace the task + uncheck the box
	            	
	            	box.setChecked(false);
        			box.setText("STRING NEXT TASK");
	            }
	            break;
	        case R.id.checkBox2:
	            if (checked) {
	            	box.setChecked(false);
	            	box.setText("STRING NEXT TASK");
	            }
	            break;
	        case R.id.checkBox3:
	            if (checked) {
	            	box.setChecked(false);
	            	box.setText("STRING NEXT TASK");
	            }
	            break;
	    }
	}
	
	public void onButtonClicked(View view) {
        Intent intent = new Intent(this, NewTaskActivity.class);
        startActivity(intent);
	}

}
