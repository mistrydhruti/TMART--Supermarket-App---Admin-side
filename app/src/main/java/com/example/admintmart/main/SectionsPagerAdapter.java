package com.example.admintmart.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.admintmart.DeliveryManagement;
import com.example.admintmart.MenuManagement;
import com.example.admintmart.OrderManagement;
import com.example.admintmart.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        //return PlaceholderFragment.newInstance(position + 1);

        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new MenuManagement();
                break;

            case 1:
                fragment = new OrderManagement();
                break;

            case 2:
                fragment = new DeliveryManagement();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Menu Management";
            case 1:
                return "Order Management";
            case 2:
                return "Delivery Management";
        }
        return  null;
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }
}