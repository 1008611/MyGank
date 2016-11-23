package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.data.GankItemData;
import com.wildwolf.mygank.data.HttpResult;
import com.wildwolf.mygank.model.IGankItemModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.GankItemService;

import java.util.List;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GankItemModelImpl implements IGankItemModel {
    @Override
    public Observable<HttpResult<List<GankItemData>>> getGankItemData(String suburl) {
        GankItemService service = NetManager.getInstance().creat(GankItemService.class);
        return service.getGankItemData(suburl);
    }
}
