package com.wildwolf.mygank.service;

import com.wildwolf.mygank.net.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/24.
 */
public interface CSDNService {

    //http://blog.csdn.net/peoplelist.html?channelid=1&page=1

    String BASE_URL = Api.URL_GET_CSDN;

    @GET("peoplelist.html")
    Observable<String> getCSDNItemData(@Query("channelid") String channelid,@Query("page") int page);
}
