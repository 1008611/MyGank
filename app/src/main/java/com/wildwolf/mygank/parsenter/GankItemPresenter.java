package com.wildwolf.mygank.parsenter;

import com.wildwolf.mygank.data.GankItemData;
import com.wildwolf.mygank.model.IGankItemModel;
import com.wildwolf.mygank.model.impl.GankItemModelImpl;
import com.wildwolf.mygank.net.RxManager;
import com.wildwolf.mygank.net.RxSubscriber;
import com.wildwolf.mygank.ui.view.GankItemView;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GankItemPresenter extends BasePresenter<GankItemView> {

    private IGankItemModel model;

    public GankItemPresenter() {
        model = new GankItemModelImpl();
    }

    public void getGankItemData(String s) {
        mSubscription = RxManager.getInstance().doSubscribe1(model.getGankItemData(s), new RxSubscriber<List<GankItemData>>(true) {
            @Override
            protected void _onNext(List<GankItemData> gankItemDatas) {
                mView.onSuccess(gankItemDatas);
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
