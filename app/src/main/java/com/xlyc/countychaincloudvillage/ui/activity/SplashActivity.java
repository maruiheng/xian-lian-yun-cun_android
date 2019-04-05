package com.xlyc.countychaincloudvillage.ui.activity;

import android.content.Intent;

import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.base.BaseActivity;
import com.xlyc.countychaincloudvillage.base.BasePresenter;
import com.xlyc.countychaincloudvillage.utils.UIUtils;
import com.xlyc.uikit.statusbar.Eyes;


/**
 * @author ChayChan
 * @description: 闪屏页
 * @date 2017/7/16  17:17
 */

public class SplashActivity extends BaseActivity {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public boolean enableSlideClose() {
        return false;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        Eyes.translucentStatusBar(this,false);//
        UIUtils.postTaskDelay(new Runnable() {
            @Override
            public void run() {
                 startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },2000);
    }
}
