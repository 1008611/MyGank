package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.model.ICSDNModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.CSDNService;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/24.
 */
public class CSDNModelImpl implements ICSDNModel {

    @Override
    public Observable<String> getCSDNData(String cid, int page) {
        CSDNService service = NetManager.getInstance().create1(CSDNService.class);
        return service.getCSDNItemData(cid,page);
    }
}
