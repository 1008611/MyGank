package com.wildwolf.mygank.model;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface IGirlItemModel {
    Observable<String> getGirlItemData(String cid, int page);
}
