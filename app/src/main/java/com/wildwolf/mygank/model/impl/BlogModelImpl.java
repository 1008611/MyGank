package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.model.IBlogModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.BlogItemService;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class BlogModelImpl implements IBlogModel {

    @Override
    public Observable<String> getBlogData(String cid,int page) {
        BlogItemService service = NetManager.getInstance().create1(BlogItemService.class);
        return service.getBlogItemData(cid, page);
    }
}
