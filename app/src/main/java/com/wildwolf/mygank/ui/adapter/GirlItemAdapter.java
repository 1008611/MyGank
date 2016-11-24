package com.wildwolf.mygank.ui.adapter;

import android.content.Context;
import android.util.Log;

import com.wildwolf.mygank.App;
import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.GirlItemData;
import com.wildwolf.mygank.ui.adapter.baseadapter.BaseAdapter;
import com.wildwolf.mygank.ui.adapter.baseadapter.ViewHolder;
import com.wildwolf.mygank.ui.widget.ScaleImageView;
import com.wildwolf.mygank.utils.ImageLoader;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GirlItemAdapter extends BaseAdapter<GirlItemData> {

    public GirlItemAdapter(Context context, List<GirlItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, GirlItemData data) {

        holder.setText(R.id.item_title,data.getTitle());
        Log.e("TAG-hi",data.getHeight()+"");

        ScaleImageView image = holder.getView(R.id.girl_item_iv);
        image.setInitSize(data.getWidth(),data.getHeight());
        ImageLoader.load(App.getContext(), data.getUrl(), image, R.drawable.web);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_girls_layout;
    }
}
