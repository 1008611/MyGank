package com.wildwolf.mygank.service;

import com.wildwolf.mygank.data.GankItemData;
import com.wildwolf.mygank.data.HttpResult;
import com.wildwolf.mygank.net.Api;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface GankItemService {
    String BASE_URL = Api.URL_GET_GANK;

    @GET("{suburl}")
    Observable<HttpResult<List<GankItemData>>> getGankItemData(@Path("suburl") String suburl);
}
