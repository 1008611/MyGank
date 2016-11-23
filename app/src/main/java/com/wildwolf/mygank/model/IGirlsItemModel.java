package com.wildwolf.mygank.model;

import com.wildwolf.mygank.data.GirlsItemData;

import java.util.List;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface IGirlsItemModel {
    Observable<List<GirlsItemData>> getGirlsItemData();
}
