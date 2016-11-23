package com.wildwolf.mygank.parsenter;

import com.wildwolf.mygank.data.GirlsItemData;
import com.wildwolf.mygank.model.IGirlsItemModel;
import com.wildwolf.mygank.model.impl.GirlsItemModelImpl;
import com.wildwolf.mygank.net.RxManager;
import com.wildwolf.mygank.net.RxSubscriber;
import com.wildwolf.mygank.ui.view.GirlsItemView;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public class GirlsItemPresenter extends BasePresenter<GirlsItemView> {

    private IGirlsItemModel mModel;

    public GirlsItemPresenter() {
        mModel = new GirlsItemModelImpl();
    }

    public void getGirlsItemData() {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getGirlsItemData(), new RxSubscriber<List<GirlsItemData>>(true) {
            @Override
            protected void _onNext(List<GirlsItemData> girlsItemDatas) {
                mView.onSuccess(girlsItemDatas);
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
