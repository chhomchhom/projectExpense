package com.projectexpense2.virackdara.projectexpense2.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import com.projectexpense2.virackdara.projectexpense2.R;

import java.util.List;

/**
 * Created by Abdisalan on 2018-05-01.
 */

public class InputPasswordActivity extends AppCompatActivity {
    PatternLockView mPatternLockView;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        password = preferences.getString("password", "0");
        mPatternLockView = (PatternLockView) findViewById(R.id.pattern_lock_view);
        mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {

            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
//                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
//                SharedPreferences.Editor editor = preferences.edit();
//                editor.putString("password", PatternLockUtils.patternToString(mPatternLockView, pattern));
//                editor.apply();
                if(password.equals(PatternLockUtils.patternToString(mPatternLockView, pattern))){
//                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(InputPasswordActivity.this, "Try Again", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCleared() {

            }
        });
    }
}