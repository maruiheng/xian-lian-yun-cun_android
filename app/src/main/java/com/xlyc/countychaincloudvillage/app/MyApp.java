package com.xlyc.countychaincloudvillage.app;

import android.app.Application;
import android.content.Context;


import com.github.anzewei.parallaxbacklayout.ParallaxHelper;
import com.socks.library.KLog;
import com.xlyc.countychaincloudvillage.BuildConfig;
import com.xlyc.countychaincloudvillage.app.base.BaseApp;

import org.litepal.LitePalApplication;

/**
 * @author ChayChan
 * @description: Application类
 * @date 2017/6/10  15:44
 */

public class MyApp extends BaseApp {
    private static Application app = null;
    @Override
    public void onCreate() {
        super.onCreate();

        //**************************************相关第三方SDK的初始化等操作*************************************************
        KLog.init(BuildConfig.DEBUG);//初始化KLog
        LitePalApplication.initialize(getApplicationContext());//初始化litePal

        registerActivityLifecycleCallbacks(ParallaxHelper.getInstance());
        app = this;

    }
    /**
     * 获取Application的Context
     **/
    public static Context getAppContext() {
        if (app == null)
            return null;
        return app.getApplicationContext();
    }
}
