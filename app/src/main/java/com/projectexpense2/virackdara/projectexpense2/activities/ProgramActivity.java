package com.projectexpense2.virackdara.projectexpense2.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.projectexpense2.virackdara.projectexpense2.R;

/**
 * Created by Abdisalan on 2018-05-01.
 */

public class ProgramActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        //login page invocation starts here
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                String password = preferences.getString("password", "0");
                if(password.equals("0")){
                    Intent intent = new Intent(getApplicationContext(),CreatePasswordActivitiy.class);
                    startActivity(intent);
                    finish();

                } else{
                    Intent intent = new Intent(getApplicationContext(),InputPasswordActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        }, 2000);
        //login page ends here
    }
}
