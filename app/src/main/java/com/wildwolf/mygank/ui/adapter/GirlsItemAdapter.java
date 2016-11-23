package com.wildwolf.mygank.ui.adapter;

import android.content.Context;

import com.wildwolf.mygank.App;
import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.GirlsItemData;
import com.wildwolf.mygank.ui.adapter.baseadapter.BaseAdapter;
import com.wildwolf.mygank.ui.adapter.baseadapter.ViewHolder;
import com.wildwolf.mygank.ui.widget.ScaleImageView;
import com.wildwolf.mygank.utils.ImageLoader;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GirlsItemAdapter extends BaseAdapter<GirlsItemData> {

    public GirlsItemAdapter(Context context, List<GirlsItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, GirlsItemData data) {
        holder.setText(R.id.item_title, data.getTitle());

        ScaleImageView image = holder.getView(R.id.girl_item_iv);
        image.setInitSize(Integer.parseInt(data.getWidth()), Integer.parseInt(data.getHeight()));
        ImageLoader.load(App.getContext(), data.getThumburl(), image, R.drawable.web);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_girls_layout;
    }
}
