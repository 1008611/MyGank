package com.wildwolf.mygank.ui.adapter;

import android.content.Context;

import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.BlogData;
import com.wildwolf.mygank.ui.adapter.baseadapter.BaseAdapter;
import com.wildwolf.mygank.ui.adapter.baseadapter.ViewHolder;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class BlogItemAdapter extends BaseAdapter<BlogData> {

    public BlogItemAdapter(Context context, List<BlogData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, BlogData data) {
        holder.setText(R.id.blog_item_desc, data.getTitle());
        holder.setText(R.id.blog_item_publishedat, data.getSubtype());
    }


    @Override
    protected int getItemLayoutId() {
        return R.layout.item_blog_layout;
    }
}
