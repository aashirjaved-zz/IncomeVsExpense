package com.example.tayyaba.incomeexpenses.CategoriesViewPager;

import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tayyabataimur on 10/5/16.
 */

public class FragmentAdapterCat extends FragmentPagerAdapter {
    int mNumOfTabsCat;

    public FragmentAdapterCat(android.support.v4.app.FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabsCat = NumOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position) {
            case 0:

                Fragment_IncomeCat tab1_cat = new Fragment_IncomeCat();
                return tab1_cat;
            case 1:
                Fragment_ExpensesCat tab2_cat = new Fragment_ExpensesCat();
                return tab2_cat;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabsCat;
    }
}