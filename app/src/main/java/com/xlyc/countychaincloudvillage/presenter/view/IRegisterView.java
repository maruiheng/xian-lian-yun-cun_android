package com.xlyc.countychaincloudvillage.presenter.view;


import com.xlyc.countychaincloudvillage.model.response.LoginResponse;

public interface IRegisterView {
    String getnum();

    String getcode();

    String gettuijianCode();

    String getPwd();

    String getrePwd();

    boolean getIschick();

    void register();

    void showLoading();

    void hideLoading();

    void getRegistercode();

    void RegisterSuccess(LoginResponse loginResponse);

    void showFailedError();

    void close();
}
