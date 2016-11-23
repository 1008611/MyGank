package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.model.IGirlDetailModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.GirlDetailService;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class GirlDetailImpl implements IGirlDetailModel {

    @Override
    public Observable<String> getGirlDetailData(String id) {
       GirlDetailService service = NetManager.getInstance().create1(GirlDetailService.class);
        return service.getGirlDetailData(id);
    }
}
