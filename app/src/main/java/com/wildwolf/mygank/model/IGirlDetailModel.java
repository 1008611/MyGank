package com.wildwolf.mygank.model;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public interface IGirlDetailModel {
    Observable<String> getGirlDetailData(String id);
}
