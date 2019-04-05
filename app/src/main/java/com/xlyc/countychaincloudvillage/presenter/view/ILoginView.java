package com.xlyc.countychaincloudvillage.presenter.view;


import com.xlyc.countychaincloudvillage.model.response.LoginResponse;

public interface ILoginView {
    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void loginSuccess(LoginResponse loginResponse);

    void showFailedError();

    void showRegister();

    void showForget();


}
