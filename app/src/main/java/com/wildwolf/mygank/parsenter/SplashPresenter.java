package com.wildwolf.mygank.parsenter;

import com.wildwolf.mygank.data.SplashData;
import com.wildwolf.mygank.model.ISplashModel;
import com.wildwolf.mygank.model.impl.SplashModelImpl;
import com.wildwolf.mygank.net.RxManager;
import com.wildwolf.mygank.net.RxSubscriber;
import com.wildwolf.mygank.ui.view.SplashView;

/**
 * Created by ${wild00wolf} on 2016/11/18.
 */
public class SplashPresenter extends BasePresenter<SplashView> {

    private ISplashModel model;

    public SplashPresenter() {
        model = new SplashModelImpl();

    }

    public void getSplashPic() {
        mSubscription = RxManager.getInstance().doSubscribe(model.getSplashPic(), new RxSubscriber<SplashData>(false) {

            @Override
            protected void _onNext(SplashData splashData) {
                mView.onSuccess(splashData);
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
