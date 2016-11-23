package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.model.IGirlItemModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.GirlItemService;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GirlItemModelImpl implements IGirlItemModel {

    @Override
    public Observable<String> getGirlItemData(String cid, int page) {
        GirlItemService service = NetManager.getInstance().create1(GirlItemService.class);
        return service.getGirlItemData(cid, page);
    }
}
