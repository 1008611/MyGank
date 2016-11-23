package com.wildwolf.mygank.service;

import com.wildwolf.mygank.net.Api;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface GirlItemService {
    String BASE_URL = Api.URL_GET_GIRL;

    //http://www.dbmeinv.com/dbgroup/show.htm?cid=2&pager_offset=1

    @GET("show.htm")
    Observable<String> getGirlItemData(@Query("cid") String cid,@Query("pager_offset") int page_offset);

}
