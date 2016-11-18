package com.wildwolf.mygank.model;

import com.wildwolf.mygank.data.SplashData;

import rx.Observable;


/**
 * Created by ${wild00wolf} on 2016/11/18.
 */
public interface ISplashModel {
    Observable<SplashData> getSplashPic();
}
