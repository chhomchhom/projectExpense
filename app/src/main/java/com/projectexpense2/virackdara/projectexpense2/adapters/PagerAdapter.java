package com.projectexpense2.virackdara.projectexpense2.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.projectexpense2.virackdara.projectexpense2.fragments.MonthTabFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.TodayTabFragment;
import com.projectexpense2.virackdara.projectexpense2.fragments.WeekTabFragment;

/**
 * Created by moham on 2018-04-19.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{

    int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numberOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                TodayTabFragment tab1 = new TodayTabFragment();
                return tab1;
            case 1:
                WeekTabFragment tab2 = new WeekTabFragment();
                return tab2;
            case 2:
                MonthTabFragment tab3 = new MonthTabFragment();
                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}