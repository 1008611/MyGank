package com.wildwolf.mygank.test;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.TestData;
import com.wildwolf.mygank.ui.activity.BaseMvpActivity;
import com.wildwolf.mygank.ui.adapter.baseadapter.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class TestActuvity extends BaseMvpActivity<MyTestView, TestPresenter> implements MyTestView, SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.type_item_recyclerview)
    RecyclerView mRecyclerView;
    @Bind(R.id.type_item_swipfreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;


    private BlogAdapter blogAdapter;

    @Override
    protected TestPresenter initPresenter() {
        return new TestPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getTestData();
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_type_item_layout;
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        //实现首次自动显示加载提示
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
            }
        });

        blogAdapter = new BlogAdapter(TestActuvity.this, new ArrayList<TestData>(), true);
        blogAdapter.setLoadingView(R.layout.load_loading_layout);


        blogAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {

                fetchData();
            }
        });

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(blogAdapter);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSuccess(List<TestData> data) {
        Log.e("TAG--title", data.get(0).getTitle());
        Log.e("TAG--size", data.size() + "");

        Log.e("TAG--url", data.get(0).getUrl());
        Log.e("TAG--type", data.get(0).getSubtype());
        Log.e("TAG--id", data.get(0).getId());

        blogAdapter.setNewData(data);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onError() {
        blogAdapter.setLoadFailedView(R.layout.load_failed_layout);

    }


    @Override
    public void onRefresh() {
        fetchData();
    }
}
