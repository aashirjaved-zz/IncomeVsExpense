package com.example.tayyaba.incomeexpenses.ExpensesViewPager;

import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Tayyaba on 9/25/2016.
 */
public class FragmentAdapterExp extends FragmentPagerAdapter {
    int mNumOfTabs;

    public FragmentAdapterExp(android.support.v4.app.FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment_ByCategoryExp tab1 = new Fragment_ByCategoryExp();
                return tab1;
            case 1:
                Fragment_ByDayExp tab2 = new Fragment_ByDayExp();
                return tab2;
            case 2:
                Fragment_DetailsExp tab3 = new Fragment_DetailsExp();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}