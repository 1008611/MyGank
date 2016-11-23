package com.wildwolf.mygank.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.GankItemData;
import com.wildwolf.mygank.parsenter.GankItemPresenter;
import com.wildwolf.mygank.ui.activity.GankDetailActivity;
import com.wildwolf.mygank.ui.adapter.GankItemAdapter;
import com.wildwolf.mygank.ui.adapter.baseadapter.OnItemClickListeners;
import com.wildwolf.mygank.ui.adapter.baseadapter.OnLoadMoreListener;
import com.wildwolf.mygank.ui.adapter.baseadapter.ViewHolder;
import com.wildwolf.mygank.ui.view.GankItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GankItemFragment extends BaseMvpFragment<GankItemView, GankItemPresenter> implements GankItemView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.type_item_recyclerview)
    RecyclerView mRecyclerview;
    @Bind(R.id.type_item_swipfreshlayout)
    SwipeRefreshLayout mSwipfreshlayout;
    @Bind(R.id.type_item_fab)
    FloatingActionButton mFab;


    private int PAGE_COUNT = 1;

    private String mSubtype;
    private int mTempPageCount = 2;
    private int mLastVisibleItemPosition;

    private GankItemAdapter mGankItemAdapter;

    private boolean isLoadMore;

    @Override
    public void onError() {
        if (isLoadMore){
            mGankItemAdapter.setLoadFailedView(R.layout.load_failed_layout);
        }else {
            mSwipfreshlayout.setRefreshing(false);
        }
    }

    @Override
    public void onSuccess(List<GankItemData> data) {
        if (isLoadMore){
            if (data.size() == 0){
                mGankItemAdapter.setLoadEndView(R.layout.load_end_layout);
            }else {
                mGankItemAdapter.setLoadMoreData(data);
                mTempPageCount++;
            }

        }else {
            mGankItemAdapter.setNewData(data);
            mSwipfreshlayout.setRefreshing(false);
        }
    }

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_type_item_layout;
    }

    @Override
    protected void initView() {
        mSwipfreshlayout.setColorSchemeResources(R.color.colorPrimary, R.color.colorAccent, R.color.colorPrimaryDark);
        mSwipfreshlayout.setOnRefreshListener(this);

        mSwipfreshlayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipfreshlayout.setRefreshing(true);
            }
        });

        mGankItemAdapter = new GankItemAdapter(mActivity,new ArrayList<GankItemData>(),true);
        mGankItemAdapter.setLoadingView(R.layout.load_loading_layout);
        mGankItemAdapter.setOnItemClickListener(new OnItemClickListeners<GankItemData>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, GankItemData data, int position) {
                Intent intent = new Intent(mActivity, GankDetailActivity.class);
                intent.putExtra("gank_item_data", data);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(mActivity,
                        viewHolder.getView(R.id.gank_item_icon), "shareView");
                ActivityCompat.startActivity(mActivity, intent, optionsCompat.toBundle());
            }
        });

        mGankItemAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                if (PAGE_COUNT == mTempPageCount && !isReload){
                    return;
                }
                isLoadMore = true;
                PAGE_COUNT = mTempPageCount;
                fetchData();
            }
        });

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(layoutManager);

        mRecyclerview.setAdapter(mGankItemAdapter);

        mRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if(mLastVisibleItemPosition <layoutManager.findLastVisibleItemPosition()&& mLastVisibleItemPosition==12){
                    mFab.show();
                }
                if (mLastVisibleItemPosition > layoutManager.findLastVisibleItemPosition() && mFab.isShown()) {
                    mFab.hide();
                }

                mLastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            }
        });
    }

    @Override
    protected void initData() {
        if (getArguments() == null){
            return;
        }
        mSubtype = getArguments().getString(SUB_TYPE);
    }

    @Override
    protected GankItemPresenter initPresenter() {
        return new GankItemPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getGankItemData("data/" + mSubtype + "/10/" + PAGE_COUNT);
    }


    @Override
    public void onRefresh() {
        isLoadMore=false;
        PAGE_COUNT=1;
        fetchData();
    }

    public static BaseMvpFragment newInstance(String title) {
        GankItemFragment fragment = new GankItemFragment();
        Bundle bundle = new Bundle();
        bundle.putString(SUB_TYPE,title);
        fragment.setArguments(bundle);
        return fragment;
    }
}
