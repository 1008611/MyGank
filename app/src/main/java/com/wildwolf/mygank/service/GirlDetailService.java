package com.wildwolf.mygank.service;

import com.wildwolf.mygank.net.Api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public interface GirlDetailService {
    String BASE_URL = Api.URL_GET_GIRL;

    @GET("{id}")
    Observable<String> getGirlDetailData(@Path("id") String id);
}
