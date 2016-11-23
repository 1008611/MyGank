package com.wildwolf.mygank.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.wildwolf.mygank.R;
import com.wildwolf.mygank.ui.adapter.TypePageAdapter;
import com.wildwolf.mygank.utils.ResourceUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ${wild00wolf} on 2016/11/18.
 */
public class TypeFragment extends BaseFragment {

    private static final String TYPE = "type";

    @Bind(R.id.type_tablayout)
    TabLayout mTablayout;
    @Bind(R.id.type_viewpager)
    ViewPager mViewpager;

    private String mType;
    private List<BaseMvpFragment> mFragments;
    private List<String> mTitles;

    private TypePageAdapter mTypeAdapter;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_type_layout;
    }

    @Override
    protected void initView() {
        mTypeAdapter = new TypePageAdapter(getChildFragmentManager());
        mTypeAdapter.setData(mFragments, mTitles);

//        mTablayout.setVisibility(View.GONE);
        mViewpager.setAdapter(mTypeAdapter);
        mViewpager.setOffscreenPageLimit(mTitles.size() - 1);
        mTablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTablayout.setupWithViewPager(mViewpager);
        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    protected void initData() {
        if (getArguments() == null) {
            return;
        }
        mFragments = new ArrayList<>();
        mType = getArguments().getString(TYPE);

        if (ResourceUtil.resToStr(mActivity, R.string.gank).equals(mType)) {
            mTitles = ResourceUtil.stringArrayToList(mActivity, R.array.gank);
            for (String title : mTitles) {
                mFragments.add(GankItemFragment.newInstance(title));
            }
        } else if (ResourceUtil.resToStr(mActivity, R.string.joke).equals(mType)) {
            mTitles = ResourceUtil.stringArrayToList(mActivity, R.array.joke);
            mFragments.add(GirlsItemFragment.newInstance("aa"));

        } else if (ResourceUtil.resToStr(mActivity, R.string.girl).equals(mType)) {
            mTitles = ResourceUtil.stringArrayToList(mActivity, R.array.girl);
            List<String> subtypes = ResourceUtil.stringArrayToList(mActivity, R.array.girl_cid);
            for (String subtype : subtypes) {
                mFragments.add(GirlItemFragment.newInstance(subtype));
            }
        } else if (ResourceUtil.resToStr(mActivity, R.string.blog).equals(mType)) {
            mTitles = ResourceUtil.stringArrayToList(mActivity, R.array.blog);
            List<String> subtypes = ResourceUtil.stringArrayToList(mActivity, R.array.blog_cid);
            for (String subtype : subtypes) {
                mFragments.add(BlogItemFragment.newInstance(subtype));
            }
        }else if (ResourceUtil.resToStr(mActivity, R.string.csdn).equals(mType)) {
            mTitles = ResourceUtil.stringArrayToList(mActivity, R.array.csdn_cid);
            List<String> subtypes = ResourceUtil.stringArrayToList(mActivity, R.array.blog_cid);
            for (String subtype : subtypes) {
                mFragments.add(BlogItemFragment.newInstance(subtype));
            }
        }
    }


    public static TypeFragment newInstance(String type) {
        TypeFragment fragment = new TypeFragment();
        Bundle args = new Bundle();
        args.putString(TYPE, type);
        fragment.setArguments(args);
        return fragment;
    }
}
