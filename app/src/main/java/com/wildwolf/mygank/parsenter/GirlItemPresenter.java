package com.wildwolf.mygank.parsenter;

import com.wildwolf.mygank.model.IGirlItemModel;
import com.wildwolf.mygank.model.impl.GirlItemModelImpl;
import com.wildwolf.mygank.net.RxManager;
import com.wildwolf.mygank.net.RxSubscriber;
import com.wildwolf.mygank.ui.view.GirlItemView;
import com.wildwolf.mygank.utils.JsoupUtil;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GirlItemPresenter extends BasePresenter<GirlItemView> {

    private IGirlItemModel mModel;

    public GirlItemPresenter() {
        mModel = new GirlItemModelImpl();
    }

    public void getGirlItemData(String cid, int page) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getGirlItemData(cid, page), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {

                mView.onSuccess(JsoupUtil.parseGirls(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
