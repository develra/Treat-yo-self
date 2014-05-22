package com.example.treat_yo_self;


import android.app.Activity;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class GoalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goal);

		//		if (savedInstanceState == null) {
		//			getFragmentManager().beginTransaction()
		//					.add(R.id.container, new PlaceholderFragment()).commit();
		//		}

		Button setgoalbtn = (Button) findViewById(R.id.goal_setGoal);


		setgoalbtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				opensetGoalDia();

			}
		});

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				/* Create an Intent that will go to the landing page. */
				Intent mainIntent = new Intent(GoalActivity.this, HomescreenActivity.class); 
				GoalActivity.this.startActivity(mainIntent);
				GoalActivity.this.finish();
			}
		}, 3000);
	}

	
	public void opensetGoalDia() {
		 AlertDialog.Builder builder = new AlertDialog.Builder(
		            GoalActivity.this, AlertDialog.THEME_HOLO_DARK);

		        // Setting Dialog Title
		        builder.setTitle("New Goal");
		        
		        builder.setMessage("Enter Your New Goal:");
		        final EditText name = new EditText(GoalActivity.this);
		        name.setTextColor(Color.WHITE);
		        name.setHint("Some Good Things");
		        
		        builder.setPositiveButton("Do It", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int which) {
		                
		            }
		        });
		        // Setting Negative "NO" Button
		        builder.setNegativeButton("Cancel",
		            new DialogInterface.OnClickListener() {
		                public void onClick(DialogInterface dialog, int which) {
		                    dialog.cancel();
		                }
		            });
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.goal, menu);
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
			View rootView = inflater.inflate(R.layout.activity_goal, container,
					false);
			return rootView;
		}
	}

}
