package com.projectexpense2.virackdara.projectexpense2.activities;

import android.content.Context;
import android.graphics.Canvas;
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
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.adapters.CategoriesAdapter;
import com.projectexpense2.virackdara.projectexpense2.fragments.ExpensesFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.HistoryFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.ReminderFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.StatisticsFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.CategoriesFragment;
import com.projectexpense2.virackdara.projectexpense2.helpers.BottomNavigationViewHelper;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

import java.util.Date;

import static com.projectexpense2.virackdara.projectexpense2.objects.Categories.listOfCategories;
import static com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard.listOfExpenseCards;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    RecyclerView mRecyclerView;
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
        mRecyclerView = findViewById(R.id.categoriesRecyclerView);
        setupItemTouch();
        //this crashes the app
//        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
//
//            boolean running;
//
//            @Override
//            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//                if (parent.getItemAnimator().isRunning()) {
//                    running = true;
//                }
//                if (running == true && !parent.getItemAnimator().isRunning()) {
//                    // first time it's not running
//                    running = false;
//                    parent.getAdapter().notifyDataSetChanged();
//                }
//                super.onDraw(c, parent, state);
//            }
//        });

        //this would be where we would read how many categories there are from a local database
        //add it to the public arraylist of categories
        //do something similar with expenses
        listOfCategories.add(0, new Categories("Food"));
        listOfCategories.add(0, new Categories("Rent"));
        listOfCategories.add(0, new Categories("School"));
        listOfCategories.add(0, new Categories("Entertainment"));

        for(int i = 0; i<=10;i++){
            Categories cat = new Categories("Food");
            ExpenseCard expenseCard = new ExpenseCard("Title"+i,i+"",new Date(),cat);
            listOfExpenseCards.add(expenseCard);
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        BottomNavigationViewHelper.removeShiftMode(navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ExpensesFragment()).commit();
    }

    //trying to implement swipe to delete
    private void setupItemTouch(){
        //Swipe to Delete
        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction)
            {
                // Do Stuff
                int swipedPosition = viewHolder.getAdapterPosition();
                CategoriesAdapter adapter = (CategoriesAdapter)mRecyclerView.getAdapter();
                adapter.remove(swipedPosition);
            }

        });
        swipeToDismissTouchHelper.attachToRecyclerView(mRecyclerView);
    }

}
