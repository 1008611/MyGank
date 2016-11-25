package com.wildwolf.mygank.parsenter;

import android.util.Log;

import com.wildwolf.mygank.model.ICSDNLibModel;
import com.wildwolf.mygank.model.impl.CSDNLibModelImpl;
import com.wildwolf.mygank.net.RxManager;
import com.wildwolf.mygank.net.RxSubscriber;
import com.wildwolf.mygank.ui.view.CSDNLibView;
import com.wildwolf.mygank.utils.JsoupUtil;

/**
 * Created by ${wild00wolf} on 2016/11/25.
 */
public class CSDNLibPresenter extends BasePresenter<CSDNLibView> {
    private ICSDNLibModel mModel;

    public CSDNLibPresenter() {
        mModel = new CSDNLibModelImpl();
    }


    public void getCSDNLibData(String article,String type,int page) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getCSDNLibData(article,type,page), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                Log.e("TAG-s", s);
                mView.onSuccess(JsoupUtil.parseCsdnLib(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}

