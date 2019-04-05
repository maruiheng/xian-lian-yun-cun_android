package com.xlyc.countychaincloudvillage.presenter;


import com.xlyc.countychaincloudvillage.api.MySubscriptionCallBack;
import com.xlyc.countychaincloudvillage.base.BasePresenter;
import com.xlyc.countychaincloudvillage.model.request.ForgetPwdRequest;
import com.xlyc.countychaincloudvillage.model.request.SmsRequtst;
import com.xlyc.countychaincloudvillage.model.response.LoginResponse;
import com.xlyc.countychaincloudvillage.presenter.view.IForgetPwdView;

public class FoegetPwdPresenter extends BasePresenter<IForgetPwdView> {


    public FoegetPwdPresenter(IForgetPwdView view) {
        super(view);
    }

    public void  submist(ForgetPwdRequest forgetPwdRequest){
        addSubscription(mApiService.getFrogetPwd(forgetPwdRequest), new MySubscriptionCallBack<LoginResponse>() {

            @Override
            protected void onSuccess(LoginResponse response) {
//                mView.showToast("");
            }

            @Override
            protected void onError() {
//                mView.showToast();
            }

        });
    }

    public void getCode(SmsRequtst requtst){
        addSubscription(mApiService.getSmsCode(requtst), new MySubscriptionCallBack<LoginResponse>() {
            @Override
            protected void onSuccess(LoginResponse response) {

            }

            @Override
            protected void onError() {

            }

        });
    }
}
