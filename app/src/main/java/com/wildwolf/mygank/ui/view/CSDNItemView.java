package com.wildwolf.mygank.ui.view;

import com.wildwolf.mygank.data.CSDNData;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/24.
 */
public interface CSDNItemView extends IBaseView{

    void onSuccess(List<CSDNData> data);
}

