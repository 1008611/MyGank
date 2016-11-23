package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.data.GirlsItemData;
import com.wildwolf.mygank.model.IGirlsItemModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.GirlsItemService;

import java.util.List;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GirlsItemModelImpl implements IGirlsItemModel {

    @Override
    public Observable<List<GirlsItemData>> getGirlsItemData() {
        GirlsItemService service = NetManager.getInstance().creat(GirlsItemService.class);
        return service.getGirlsItemData();
    }
}
