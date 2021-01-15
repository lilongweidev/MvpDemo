package com.llw.mvpdemo.application;

import com.llw.mvplibrary.BaseApplication;
import com.llw.mvplibrary.network.NetworkApi;


/**
 * 自定义Application
 * @author llw
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        NetworkApi.init(new NetworkRequiredInfo(this));
    }
}
