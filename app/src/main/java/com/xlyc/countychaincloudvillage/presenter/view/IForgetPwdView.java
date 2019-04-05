package com.xlyc.countychaincloudvillage.presenter.view;

public interface IForgetPwdView {
    void showToast(String msg);
    void getsmsCode();
    void submit();
    void close();

    String getNum();
    String getSmsCode();
    String getPwd();
}
