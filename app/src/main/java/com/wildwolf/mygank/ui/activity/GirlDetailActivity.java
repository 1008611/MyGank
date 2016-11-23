package com.wildwolf.mygank.ui.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wang.avi.AVLoadingIndicatorView;
import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.GirlItemData;
import com.wildwolf.mygank.parsenter.GirlDetailresenter;
import com.wildwolf.mygank.ui.adapter.GirlDetailAdapter;
import com.wildwolf.mygank.ui.fragment.BaseFragment;
import com.wildwolf.mygank.ui.fragment.GirlDetailFragment;
import com.wildwolf.mygank.ui.view.GirlDetailView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class GirlDetailActivity extends BaseMvpActivity<GirlDetailView, GirlDetailresenter> implements GirlDetailView {

    private GirlItemData mGirlItemData;

    @Bind(R.id.girl_detail_toolbar)
    Toolbar mToolbar;

    @Bind(R.id.girl_detail_viewpager)
    ViewPager mViewPager;
    @Bind(R.id.girl_detail_loading)
    AVLoadingIndicatorView mLoading;

    @Override
    protected GirlDetailresenter initPresenter() {
        return new GirlDetailresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getGirlsDetailData(mGirlItemData.getId());
    }

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
        String title = mGirlItemData.getTitle();
        title = title.length() > 10 ? title.substring(0, 10) + "..." : title;
        mToolbar.setTitle(title);

        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void initData() {
        mGirlItemData = getIntent().getParcelableExtra("girl_item_data");
    }

    @Override
    public void onSuccess(List<String> data) {
        List<BaseFragment> fragments = new ArrayList<>();
        for (String url : data) {
            fragments.add(GirlDetailFragment.newInstance(url));
        }

        GirlDetailAdapter adapter = new GirlDetailAdapter(getSupportFragmentManager());
        adapter.setData(fragments);

        mViewPager.setOffscreenPageLimit(data.size());
        mViewPager.setAdapter(adapter);

        mLoading.hide();
    }

    @Override
    public void onError() {

    }


}
