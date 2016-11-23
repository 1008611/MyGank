package com.wildwolf.mygank.test;

import android.content.Context;

import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.TestData;
import com.wildwolf.mygank.ui.adapter.baseadapter.BaseAdapter;
import com.wildwolf.mygank.ui.adapter.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class BlogAdapter extends BaseAdapter<TestData> {


    public BlogAdapter(Context context, List<TestData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, TestData data) {
        holder.setText(R.id.item_title, data.getTitle());
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_girls_layout;
    }
}

