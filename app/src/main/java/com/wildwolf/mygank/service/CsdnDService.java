package com.wildwolf.mygank.service;

import com.wildwolf.mygank.net.Api;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/24.
 */
public interface CsdnDService {

    String BASE_URL = Api.URL_GET_BLOG;

    @GET("/{name}/article/list/{p}")
    Observable<String> getBlogItemData(@Path("name") String name, @Path("p") int p);


}
