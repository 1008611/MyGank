package com.wildwolf.mygank.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wildwolf.mygank.ui.fragment.BaseFragment;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class GirlDetailAdapter extends FragmentPagerAdapter {


    private List<BaseFragment> fragments;

    public GirlDetailAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void setData(List<BaseFragment> fragments) {
        this.fragments = fragments;
    }
}
