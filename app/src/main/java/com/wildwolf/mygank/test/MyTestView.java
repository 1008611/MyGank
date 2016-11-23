package com.wildwolf.mygank.test;

import com.wildwolf.mygank.data.TestData;
import com.wildwolf.mygank.ui.view.IBaseView;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/21.
 */
public interface MyTestView extends IBaseView{
    void onSuccess(List<TestData> data);
}
