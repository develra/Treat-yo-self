package com.example.treat_yo_self;

import java.sql.Date;

import com.example.treat_yo_self.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class NewTaskActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_task);
		final CheckBox importance1 = (CheckBox) findViewById(R.id.importance1);
		final CheckBox importance2 = (CheckBox) findViewById(R.id.importance2);
		final CheckBox importance3 = (CheckBox) findViewById(R.id.importance3);
		importance1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if ((importance1.isChecked() && importance2.isChecked()) || (importance1.isChecked() && importance3.isChecked()) || (importance2.isChecked() && importance3.isChecked())) {
					Toast error = Toast.makeText(getApplicationContext(), "Choose One Scoop", Toast.LENGTH_SHORT);
					error.show();
					importance2.setChecked(false);
					importance3.setChecked(false);
				}
			}
		});
		
		importance2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if ((importance1.isChecked() && importance2.isChecked()) || (importance1.isChecked() && importance3.isChecked()) || (importance2.isChecked() && importance3.isChecked())) {
					Toast error = Toast.makeText(getApplicationContext(), "Choose One Scoop", Toast.LENGTH_SHORT);
					error.show();
					importance2.setChecked(false);
					importance3.setChecked(false);
				}
			}
		});
		
		
		importance3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				if ((importance1.isChecked() && importance2.isChecked()) || (importance1.isChecked() && importance3.isChecked()) || (importance2.isChecked() && importance3.isChecked())) {
					Toast error = Toast.makeText(getApplicationContext(), "Choose One Scoop", Toast.LENGTH_SHORT);
					error.show();
					importance2.setChecked(false);
					importance3.setChecked(false);
				}
			}
		});
		
		
		final TextView date = (TextView) findViewById(R.id.newTaks_date);
		date.addTextChangedListener(new TextWatcher() {
				@Override
				public void afterTextChanged(Editable arg0) {
					if (arg0.length() == 2 || arg0.length() == 5) {
						String changed = arg0.append('-').toString();
						date.setText(changed);
					    EditText d = (EditText) findViewById(R.id.newTaks_date);
					    d.setSelection(changed.length());
					}
					
				}

				@Override
				public void beforeTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {					
				}

				@Override
				public void onTextChanged(CharSequence arg0, int arg1,
						int arg2, int arg3) {
					// TODO Auto-generated method stub
					
				}
		});
		/*
		 * Setting up the button to create a new transaction. 
		 */
		Button create = (Button) findViewById(R.id.newTransaction_create);
		
		create.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {
				
				//Trying to create a cancel button
//				System.out.println(v.getId());
//				if(v.getId() == (R.id.cancelbutton)) {
//					System.out.println("pressed cancel button");
//					Intent TasksIntent = new Intent(getApplicationContext(),
//							TasksActivity.class);
//					startActivity(TasksIntent);
//				}
				
				String name = ((EditText) findViewById(R.id.newTask_name)).getText().toString();
				//String source = ((EditText) findViewById(R.id.transkind)).getText().toString();
				//String type;
				String date = ((EditText) findViewById(R.id.newTaks_date))
						.getText().toString();
				try{
					@SuppressWarnings("deprecation")
					Date date1 = new Date(Integer.parseInt(date.substring(0, 2)), Integer.parseInt(date.substring(3, 5)),Integer.parseInt(date.substring(6, 10)));
					
					if (importance1.isChecked()) {
						Task newTask = new Task(name, 10, date1, 1);
						//DB STUFF GO HERE!!! ASSIGN TASK TO USER
						Intent TasksIntent = new Intent(getApplicationContext(),
								TasksActivity.class);
						startActivity(TasksIntent);
					} else if (importance2.isChecked()) {
						Task newTask = new Task(name, 10, date1, 2);
						//DB STUFF GO HERE!!! ASSIGN TASK TO USER
						Intent TasksIntent = new Intent(getApplicationContext(),
								TasksActivity.class);
						startActivity(TasksIntent);
					} else if (importance3.isChecked()) {
						Task newTask = new Task(name, 10, date1, 3);
						//DB STUFF GO HERE!!! ASSIGN TASK TO USER
						Intent TasksIntent = new Intent(getApplicationContext(),
								TasksActivity.class);
						startActivity(TasksIntent);
					} else if (!importance1.isChecked() && !importance2.isChecked() && importance3.isChecked()) {
						Toast error = Toast.makeText(getApplicationContext(), "Please choose a scoop", Toast.LENGTH_SHORT);
						error.show();
					}
				} catch (Exception e){
					Toast error = Toast.makeText(getApplicationContext(), "Please enter a valid amount (a number)/valid date.", Toast.LENGTH_SHORT);
					error.show();
				}
			}

		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.new_task, menu);
		return true;
	}

}
