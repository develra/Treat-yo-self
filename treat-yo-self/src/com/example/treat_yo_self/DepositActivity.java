package com.example.treat_yo_self;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Michael on 5/21/2014.
 */
public class DepositActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        //Button deposit_button=findViewById(R.id.deposit_button);
    }

    public void make_Deposit(View view) {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
    }
}