package com.xlyc.countychaincloudvillage.presenter;


import com.xlyc.countychaincloudvillage.api.MySubscriptionCallBack;
import com.xlyc.countychaincloudvillage.base.BasePresenter;
import com.xlyc.countychaincloudvillage.model.request.LoginRequest;
import com.xlyc.countychaincloudvillage.model.response.LoginResponse;
import com.xlyc.countychaincloudvillage.presenter.view.ILoginView;

public class LoginPresenter extends BasePresenter<ILoginView> {
    public LoginPresenter(ILoginView view) {
        super(view);
    }

    public void login(String username, String pwd) {
        LoginRequest re = new LoginRequest();
        re.setAccount(username);
        re.setPasswd(pwd);
        addSubscription(mApiService.getLoginmessage(re), new MySubscriptionCallBack<LoginResponse>() {

            @Override
            protected void onSuccess(LoginResponse response) {
                mView.loginSuccess(response);
            }

            @Override
            protected void onError() {
                mView.showFailedError();
            }
        });

    }
}
