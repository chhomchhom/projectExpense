package com.projectexpense2.virackdara.projectexpense2.activities;

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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.fragments.ExpensesFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.HistoryFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.ReminderFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.StatisticsFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.CategoriesFragment;
import com.projectexpense2.virackdara.projectexpense2.helpers.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

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

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ExpensesFragment()).commit();
    }

}
