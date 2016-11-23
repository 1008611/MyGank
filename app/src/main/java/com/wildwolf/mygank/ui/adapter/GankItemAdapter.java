package com.wildwolf.mygank.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.wildwolf.mygank.App;
import com.wildwolf.mygank.R;
import com.wildwolf.mygank.data.GankItemData;
import com.wildwolf.mygank.ui.adapter.baseadapter.BaseAdapter;
import com.wildwolf.mygank.ui.adapter.baseadapter.ViewHolder;
import com.wildwolf.mygank.utils.ImageLoader;

import java.util.List;


/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GankItemAdapter extends BaseAdapter<GankItemData> {


    public GankItemAdapter(Context context, List<GankItemData> datas, boolean isOpenLoadMore) {
        super(context, datas, isOpenLoadMore);
    }

    @Override
    protected void convert(ViewHolder holder, GankItemData data) {
        holder.setText(R.id.gank_item_desc,data.getDesc());

        String who = TextUtils.isEmpty(data.getWho())? "null":data.getWho();
        holder.setText(R.id.gank_item_who,who);

        holder.setText(R.id.gank_item_publishedat,data.getPublishedAt().substring(0,10));
        ImageView image = holder.getView(R.id.gank_item_icon);
        String[] images = data.getImages();
        if (images != null && images.length > 0) {
            ImageLoader.load(App.getContext(),
                    images[0] + "?imageView2/0/w/100", image, R.drawable.web);
        } else {
            String url = data.getUrl();
            int iconId;
            if (url.contains("github")) {
                iconId = R.drawable.github;
            } else if (url.contains("jianshu")) {
                iconId = R.drawable.jianshu;
            } else if (url.contains("csdn")) {
                iconId = R.drawable.csdn;
            } else if (url.contains("miaopai")) {
                iconId = R.drawable.miaopai;
            } else if (url.contains("acfun")) {
                iconId = R.drawable.acfun;
            } else if (url.contains("bilibili")) {
                iconId = R.drawable.bilibili;
            } else if (url.contains("youku")) {
                iconId = R.drawable.youku;
            } else if (url.contains("weibo")) {
                iconId = R.drawable.weibo;
            } else if (url.contains("weixin")) {
                iconId = R.drawable.weixin;
            } else {
                iconId = R.drawable.web;
            }
            ImageLoader.load(App.getContext(), iconId, image);
        }
    }


    @Override
    protected int getItemLayoutId() {
        return R.layout.item_gank_layout;
    }
}
