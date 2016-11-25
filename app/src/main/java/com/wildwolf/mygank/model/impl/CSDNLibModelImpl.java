package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.model.ICSDNLibModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.CSDNLibService;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/25.
 */
public class CSDNLibModelImpl implements ICSDNLibModel {

    @Override
    public Observable<String> getCSDNLibData(String article,String type,int page) {
        CSDNLibService service = NetManager.getInstance().create1(CSDNLibService.class);
        return service.getCSDNLibData(article,type,page);
    }
}
