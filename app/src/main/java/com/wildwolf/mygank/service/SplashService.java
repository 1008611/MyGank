package com.wildwolf.mygank.service;

import com.wildwolf.mygank.data.SplashData;
import com.wildwolf.mygank.net.Api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/18.
 */
public interface SplashService {
    String BASE_URL = Api.URL_GET_SPLASH_PIC;

    @GET("1080*1920")
    Observable<SplashData> getSplashPic();
}
