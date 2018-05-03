package com.projectexpense2.virackdara.projectexpense2.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import com.projectexpense2.virackdara.projectexpense2.adapters.ExpenseCardAdapter;
import com.projectexpense2.virackdara.projectexpense2.adapters.PagerAdapter;
import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.fragments.ExpensesFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.HistoryFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.MonthTabFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.ReminderFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.StatisticsFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.TodayTabFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.WeekTabFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.CategoriesFragment;
import com.projectexpense2.virackdara.projectexpense2.helpers.BottomNavigationViewHelper;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selected = null;
            switch (item.getItemId()) {
                case R.id.navigation_expenses:
                    selected = new ExpensesFragment();
                    break;
                case R.id.navigation_categories:
                    selected = new CategoriesFragment();
                    break;
                case R.id.navigation_statistics:
                    selected = new StatisticsFragment();
                    break;
                case R.id.navigation_reminder:
                    selected = new ReminderFragment();
                    break;
                case R.id.navigation_history:
                    selected = new HistoryFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selected).commit();
            return true;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //login page invocation starts here
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
//                String password = preferences.getString("password", "0");
//                if(password.equals("0")){
//                    Intent intent = new Intent(getApplicationContext(),CreatePasswordActivitiy.class);
//                    startActivity(intent);
//                    finish();
//
//                } else{
//                    Intent intent = new Intent(getApplicationContext(),InputPasswordActivity.class);
//                    startActivity(intent);
//                    finish();
//
//                }
//            }
//        }, 2000);
//        //login page ends here
        //invoke program activity
        launchProgramActivity();



        //mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ExpensesFragment()).commit();
    }
    private void launchProgramActivity(){
        Intent intent = new Intent(getApplicationContext(),ProgramActivity.class);
        startActivity(intent);
        //finish();
    }


}
