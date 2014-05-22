package com.example.treat_yo_self;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Michael on 5/21/2014.
 */
public class LoginActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        Parse.initialize(this, "IpTVhN6pW1NELloHetmRvoHLzSlnWqVnnTGMBvX5", "KqkQyLx5eXtv3cDib3Phec9F5amTgKGznMn9YWPv");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ParseObject testObject = new ParseObject("TestObject");
        testObject.put("foo", "bar");
        testObject.saveInBackground();
    }

    public void gtHome(View view) {
        Intent intent = new Intent(this, HomescreenActivity.class);
        startActivity(intent);
    }

    public void gtRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}