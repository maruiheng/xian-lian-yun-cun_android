package com.xlyc.countychaincloudvillage.presenter;


import com.xlyc.countychaincloudvillage.api.MySubscriptionCallBack;
import com.xlyc.countychaincloudvillage.base.BasePresenter;
import com.xlyc.countychaincloudvillage.model.request.RegisterRequest;
import com.xlyc.countychaincloudvillage.model.request.SmsRequtst;
import com.xlyc.countychaincloudvillage.model.response.LoginResponse;
import com.xlyc.countychaincloudvillage.presenter.view.IRegisterView;

public class RegisterPresenter extends BasePresenter<IRegisterView> {

    public RegisterPresenter(IRegisterView view) {
        super(view);
    }

    public void register(RegisterRequest request) {
        mView.showLoading();
        addSubscription(mApiService.getRegister(request), new MySubscriptionCallBack<LoginResponse>() {
            @Override
            protected void onSuccess(LoginResponse response) {
                mView.RegisterSuccess(response);
            }

            @Override
            protected void onError() {
                mView.showFailedError();
            }

        });
        mView.hideLoading();
    }

    public void getSmsCode(SmsRequtst requtst) {
        mView.showLoading();
        addSubscription(mApiService.getSmsCode(requtst), new MySubscriptionCallBack<LoginResponse>() {
            @Override
            protected void onSuccess(LoginResponse response) {

            }

            @Override
            protected void onError() {

            }
        });
        mView.hideLoading();
    }

}
