package com.wildwolf.mygank;

import android.app.Application;
import android.content.Context;

import com.wildwolf.mygank.utils.SPUtil;

/**
 * Created by ${wild00wolf} on 2016/11/18.
 */
public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();

        initRealm();
        SPUtil.init(mContext, "sp");
    }

    private void initRealm() {

    }

    public static Context getContext(){
        return mContext;
    }

}
