package com.xlyc.countychaincloudvillage.ui.fragment;

import android.view.View;
import android.widget.RelativeLayout;


import com.socks.library.KLog;
import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.base.BaseFragment;
import com.xlyc.countychaincloudvillage.base.BasePresenter;

import butterknife.Bind;

/**
 * @author ChayChan
 * @description: 我的fragment
 * @date 2017/6/12  21:47
 */

public class MineFragment extends BaseFragment {
    @Bind(R.id.user_layout)
    RelativeLayout userLayout;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return  R.layout.fragment_mine;
    }

    @Override
    public void initView(View rootView) {
        KLog.i("initView");
    }

    @Override
    public void initData() {
        KLog.i("initData");
    }

    @Override
    public void initListener() {
        KLog.i("initListener");
        userLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginFragment loginFragment = new LoginFragment();
                loginFragment.show(getChildFragmentManager(), "CHANNEL");
            }
        });
    }

    @Override
    public void loadData() {
        KLog.i("loadData");
    }
}
