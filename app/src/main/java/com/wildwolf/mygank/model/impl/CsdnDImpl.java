package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.model.ICsdnDModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.CsdnDService;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/24.
 */
public class CsdnDImpl implements ICsdnDModel {
    @Override
    public Observable<String> getCsdnData(String name,int page) {
        CsdnDService service = NetManager.getInstance().create1(CsdnDService.class);
        return service.getBlogItemData(name,page);
    }
}
