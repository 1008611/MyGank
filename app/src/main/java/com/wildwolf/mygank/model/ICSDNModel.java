package com.wildwolf.mygank.model;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/24.
 */
public interface ICSDNModel {
    Observable<String> getCSDNData(String cid,int page);
}
