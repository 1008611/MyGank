package com.wildwolf.mygank.model.impl;

import com.wildwolf.mygank.data.SplashData;
import com.wildwolf.mygank.model.ISplashModel;
import com.wildwolf.mygank.net.NetManager;
import com.wildwolf.mygank.service.SplashService;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/18.
 */
public class SplashModelImpl implements ISplashModel {
    @Override
    public Observable<SplashData> getSplashPic() {
        SplashService service = NetManager.getInstance().creat(SplashService.class);
        return service.getSplashPic();
    }
}
