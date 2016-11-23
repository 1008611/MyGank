package com.wildwolf.mygank.ui.view;

import com.wildwolf.mygank.data.GankItemData;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface GankItemView  extends IBaseView{
    void onSuccess(List<GankItemData> data);
}
