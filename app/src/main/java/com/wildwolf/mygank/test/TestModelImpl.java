package com.wildwolf.mygank.test;

import com.wildwolf.mygank.net.NetManager;

import rx.Observable;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class TestModelImpl implements ITestModel {
    @Override
    public Observable<String> getTestData() {
        TestService service = NetManager.getInstance().create1(TestService.class);
        return service.getTestData();
    }
}
