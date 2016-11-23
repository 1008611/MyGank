package com.wildwolf.mygank.ui.view;

import com.wildwolf.mygank.data.GirlItemData;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface GirlItemView extends IBaseView{

    void onSuccess(List<GirlItemData> data);
}
