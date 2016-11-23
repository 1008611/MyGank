package com.wildwolf.mygank.service;

import com.wildwolf.mygank.data.GirlsItemData;
import com.wildwolf.mygank.net.Api;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface GirlsItemService {
    String BASE_URL = Api.URL_GET_GIRLS;

    @GET("tupian.json")
    Observable<List<GirlsItemData>> getGirlsItemData();
}
