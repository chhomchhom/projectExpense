package com.projectexpense2.virackdara.projectexpense2.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.projectexpense2.virackdara.projectexpense2.R;
import com.projectexpense2.virackdara.projectexpense2.activities.SettingsActivity;
import com.projectexpense2.virackdara.projectexpense2.adapters.PagerAdapter;
import com.projectexpense2.virackdara.projectexpense2.objects.Categories;
import com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard;

import java.util.Date;

import static com.projectexpense2.virackdara.projectexpense2.objects.ExpenseCard.dayTotal;

public class ExpensesFragment extends Fragment{

    private TextView totalTextBox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_expense, container, false);
        Toolbar toolbar = rootView.findViewById(R.id.toolbarExpense);
        toolbar.setTitle("");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);


        TabLayout tabLayout = rootView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Today"));
        tabLayout.addTab(tabLayout.newTab().setText("Week"));
        tabLayout.addTab(tabLayout.newTab().setText("Month"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        totalTextBox = rootView.findViewById(R.id.total);
        totalTextBox.setText(dayTotal+"");

        final ViewPager viewPager = rootView.findViewById(R.id.pager);
        final PagerAdapter pagerAdapter = new PagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                totalTextBox = rootView.findViewById(R.id.total);
                totalTextBox.setText(dayTotal+"");

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



        return rootView;

    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_with_addbtn, menu);  // Use filter.xml from step 1
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.settings:
                Intent myIntent = new Intent(getContext(), SettingsActivity.class);
                getContext().startActivity(myIntent);
                return true;
            case R.id.add_button:
                openExpenseDialog();
                return true;

            default:
                break;
        }

        return false;
    }

    public void openExpenseDialog(){
        ExpenseDialogFragment expenseDialogFragment = new ExpenseDialogFragment();
        expenseDialogFragment.show(getFragmentManager(),"Example");
    }

//    @Override
//    public void applyTexts(String title, String amount, String description){
//        addExpense(String title, String amount, String description, Categories cat)
//    }

}
