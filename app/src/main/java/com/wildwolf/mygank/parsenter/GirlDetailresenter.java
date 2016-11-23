package com.wildwolf.mygank.parsenter;

import com.wildwolf.mygank.model.IGirlDetailModel;
import com.wildwolf.mygank.model.impl.GirlDetailImpl;
import com.wildwolf.mygank.net.RxManager;
import com.wildwolf.mygank.net.RxSubscriber;
import com.wildwolf.mygank.ui.view.GirlDetailView;
import com.wildwolf.mygank.utils.JsoupUtil;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class GirlDetailresenter extends BasePresenter<GirlDetailView> {

    private IGirlDetailModel model;

    public GirlDetailresenter() {
        model = new GirlDetailImpl();
    }


    public void getGirlsDetailData(String id) {
        mSubscription = RxManager.getInstance().doSubscribe(model.getGirlDetailData(id), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                mView.onSuccess(JsoupUtil.parseGirlDetail(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
