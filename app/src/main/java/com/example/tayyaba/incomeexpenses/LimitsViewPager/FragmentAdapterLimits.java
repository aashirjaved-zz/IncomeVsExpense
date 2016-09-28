package com.example.tayyaba.incomeexpenses.LimitsViewPager;

import android.support.v4.app.FragmentPagerAdapter;

import com.example.tayyaba.incomeexpenses.IncomeViewPager.Fragment_ByCategoryInc;
import com.example.tayyaba.incomeexpenses.IncomeViewPager.Fragment_ByDayInc;

/**
 * Created by Tayyaba on 9/26/2016.
 */
public class FragmentAdapterLimits extends FragmentPagerAdapter {
    int mNumOfTabs;

    public FragmentAdapterLimits(android.support.v4.app.FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment_DefinedLimits tab1 = new Fragment_DefinedLimits();
                return tab1;
            case 1:
                Fragment_ThisMonth tab2 = new Fragment_ThisMonth();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
