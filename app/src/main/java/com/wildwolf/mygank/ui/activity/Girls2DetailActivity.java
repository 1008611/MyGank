package com.wildwolf.mygank.ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.wang.avi.AVLoadingIndicatorView;
import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.GirlsItemData;
import com.wildwolf.mygank.ui.adapter.GirlDetailAdapter;
import com.wildwolf.mygank.ui.fragment.BaseFragment;
import com.wildwolf.mygank.ui.fragment.Girl2DetailFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class Girls2DetailActivity extends BaseActivity {

    private GirlsItemData mGirlItemData ;

    @Bind(R.id.girl_detail_toolbar)
    Toolbar mToolbar;

    @Bind(R.id.girl_detail_viewpager)
    ViewPager mViewPager;
    @Bind(R.id.girl_detail_loading)
    AVLoadingIndicatorView mLoading;


    @Override
    protected int initLayoutId() {
        return R.layout.activity_girl_detail;
    }

    @Override
    protected void initView() {
        initToolbar();
    }

    private void initToolbar() {
        //setTitle方法要在setSupportActionBar(toolbar)之前调用，否则不起作用
        String title = "---";
        title = title.length() > 10 ? title.substring(0, 10) + "..." : title;
        mToolbar.setTitle(title);

    }

    @Override
    protected void initData() {
        mGirlItemData = getIntent().getParcelableExtra("girls_data");
//
//        Log.e("TAG---1",mGirlItemData.toString()+"");
//        Log.e("TAG---2",mGirlItemData.getTitle());
//        Log.e("TAG---3",mGirlItemData.getUrl());
//
//        List<String> data=new ArrayList<>();


//
//        for (int i=0;i<mGirlItemData.size();i++){
//            data.add(mGirlItemData.get(i).getUrl());
//        }

        List<BaseFragment> fragments = new ArrayList<>();
//        for (String url : data) {
            fragments.add(Girl2DetailFragment.newInstance(mGirlItemData.getThumburl()));
//        }

        GirlDetailAdapter adapter = new GirlDetailAdapter(getSupportFragmentManager());
        adapter.setData(fragments);


        mViewPager.setAdapter(adapter);

    }

//    @Override
//    public void onSuccess(List<String> data) {
//        List<BaseFragment> fragments = new ArrayList<>();
//        for (String url : data) {
//            fragments.add(Girl2DetailFragment.newInstance(url));
//        }
//
//        GirlDetailAdapter adapter = new GirlDetailAdapter(getSupportFragmentManager());
//        adapter.setData(fragments);
//
//        mViewPager.setOffscreenPageLimit(data.size());
//        mViewPager.setAdapter(adapter);
//
//        mLoading.hide();
//    }


}
