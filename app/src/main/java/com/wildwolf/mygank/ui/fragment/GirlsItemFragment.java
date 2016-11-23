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
import com.wildwolf.mygank.data.GirlsItemData;
import com.wildwolf.mygank.parsenter.GirlsItemPresenter;
import com.wildwolf.mygank.ui.activity.Girls2DetailActivity;
import com.wildwolf.mygank.ui.activity.GirlsDetailActivity;
import com.wildwolf.mygank.ui.adapter.GankItemAdapter;
import com.wildwolf.mygank.ui.adapter.GirlsItemAdapter;
import com.wildwolf.mygank.ui.adapter.baseadapter.OnItemClickListeners;
import com.wildwolf.mygank.ui.adapter.baseadapter.OnLoadMoreListener;
import com.wildwolf.mygank.ui.adapter.baseadapter.ViewHolder;
import com.wildwolf.mygank.ui.view.GirlsItemView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GirlsItemFragment extends BaseMvpFragment<GirlsItemView, GirlsItemPresenter> implements GirlsItemView, SwipeRefreshLayout.OnRefreshListener {

    private int PAGE_COUNT = 1;

    private int mTempPageCount = 2;
    private int mLastVisibleItemPosition;

    private GirlsItemAdapter girlsItemAdapter;

    private boolean isLoadMore;

    @Bind(R.id.type_item_recyclerview)
    RecyclerView mRecyclerView;

    @Bind(R.id.type_item_fab)
    FloatingActionButton mFab;

    @Bind(R.id.type_item_swipfreshlayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @OnClick(R.id.type_item_fab)
    void onClick() {
        mRecyclerView.smoothScrollToPosition(0);
    }

    public static GirlsItemFragment newInstance(String subtype) {
        GirlsItemFragment fragment = new GirlsItemFragment();
        Bundle arguments = new Bundle();
        arguments.putString(SUB_TYPE,"subtype");
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    protected GirlsItemPresenter initPresenter() {
        return new GirlsItemPresenter();
    }

    @Override
    protected void fetchData() {
        mPresenter.getGirlsItemData();
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


        girlsItemAdapter = new GirlsItemAdapter(mActivity, new ArrayList<GirlsItemData>(), true);
        girlsItemAdapter.setLoadingView(R.layout.load_loading_layout);
        girlsItemAdapter.setOnItemClickListener(new OnItemClickListeners<GirlsItemData>() {
            @Override
            public void onItemClick(ViewHolder viewHolder, GirlsItemData data, int position) {
                Intent intent = new Intent(getActivity(), Girls2DetailActivity.class);
                intent.putExtra("girls_data",data);
                startActivity(intent);
            }
        });

        girlsItemAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(boolean isReload) {
                if (PAGE_COUNT == mTempPageCount && !isReload) {
                    return;
                }
                isLoadMore = true;
                PAGE_COUNT = mTempPageCount;
                fetchData();
            }
        });

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        mRecyclerView.setAdapter(girlsItemAdapter);

        //RecyclerView滚动监听
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (mLastVisibleItemPosition < layoutManager.findLastVisibleItemPosition() && mLastVisibleItemPosition == 12) {
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
        if (getArguments() == null) {
            return;
        }

    }

    @Override
    public void onSuccess(List<GirlsItemData> data) {
        girlsItemAdapter.setNewData(data);
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onError() {
        girlsItemAdapter.setLoadFailedView(R.layout.load_failed_layout);
    }

    @Override
    public void onRefresh() {
        fetchData();
    }
}
