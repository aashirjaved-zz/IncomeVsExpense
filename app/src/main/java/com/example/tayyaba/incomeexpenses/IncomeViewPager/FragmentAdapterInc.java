package com.example.tayyaba.incomeexpenses.IncomeViewPager;

import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Tayyaba on 9/26/2016.
 */
public class FragmentAdapterInc extends FragmentPagerAdapter {
    int mNumOfTabs;

    public FragmentAdapterInc(android.support.v4.app.FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position) {
            case 0:
                Fragment_ByCategoryInc tab1 = new Fragment_ByCategoryInc();
                return tab1;
            case 1:
                Fragment_ByDayInc tab2 = new Fragment_ByDayInc();
                return tab2;
            case 2:
                Fragment_DetailsInc tab3 = new Fragment_DetailsInc();
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