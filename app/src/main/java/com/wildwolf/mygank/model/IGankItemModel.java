package com.wildwolf.mygank.model;

import com.wildwolf.mygank.data.GankItemData;
import com.wildwolf.mygank.data.HttpResult;

import java.util.List;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface IGankItemModel {
    Observable<HttpResult<List<GankItemData>>> getGankItemData(String suburl);
}
