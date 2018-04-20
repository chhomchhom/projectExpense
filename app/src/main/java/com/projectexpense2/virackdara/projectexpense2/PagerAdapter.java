package com.projectexpense2.virackdara.projectexpense2;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

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
                TodayTabActivity tab1 = new TodayTabActivity();
                return  tab1;
            case 1:
                WeekTabActivity tab2 = new WeekTabActivity();
                return tab2;
            case 2:
                MonthTabActivity tab3 = new MonthTabActivity();
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