package com.wildwolf.mygank.test;

import com.wildwolf.mygank.net.Api;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface TestService {
    String BASE_URL = Api.URL_GET_TEST;

    //http://www.dbmeinv.com/dbgroup/show.htm?cid=2&pager_offset=1

    @GET("/v2_action/article_list?huxiu_hash_code=8dfc26c81a1ced305b2ebe32fd2dcb8f&page=2&catid=1&last_dateline=1479734880")
    Observable<String> getTestData();
}
