package com.wildwolf.mygank.test;

import android.util.Log;

import com.wildwolf.mygank.net.RxManager;
import com.wildwolf.mygank.net.RxSubscriber;
import com.wildwolf.mygank.parsenter.BasePresenter;
import com.wildwolf.mygank.utils.JsoupUtil;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class TestPresenter extends BasePresenter<MyTestView> {
    private ITestModel mModel;

    public TestPresenter() {
        mModel = new TestModelImpl();
    }

    public void getTestData() {


            mSubscription = RxManager.getInstance().doSubscribe(mModel.getTestData(), new RxSubscriber<String>(false) {
                @Override
                protected void _onNext(String s) {
                    Log.e("TAG--html",s);
                    mView.onSuccess(JsoupUtil.parseTest(s));
                }

                @Override
                protected void _onError() {
                    mView.onError();
                }
            });

    }
}
