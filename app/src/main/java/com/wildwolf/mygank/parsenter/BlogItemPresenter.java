package com.wildwolf.mygank.parsenter;

import android.util.Log;

import com.wildwolf.mygank.model.IBlogModel;
import com.wildwolf.mygank.model.impl.BlogModelImpl;
import com.wildwolf.mygank.net.RxManager;
import com.wildwolf.mygank.net.RxSubscriber;
import com.wildwolf.mygank.ui.view.BlogItemView;
import com.wildwolf.mygank.utils.JsoupUtil;

/**
 * Created by ${wild00wolf} on 2016/11/22.
 */
public class BlogItemPresenter extends BasePresenter<BlogItemView> {
    private IBlogModel mModel;

    public BlogItemPresenter() {
        mModel = new BlogModelImpl();
    }


    public void getBlogItemData(String cid, int page) {
        mSubscription = RxManager.getInstance().doSubscribe(mModel.getBlogData(cid,page), new RxSubscriber<String>(false) {
            @Override
            protected void _onNext(String s) {
                Log.e("TAG-",s);
                mView.onSuccess(JsoupUtil.parseTest2(s));
            }

            @Override
            protected void _onError() {
                mView.onError();
            }
        });
    }
}
