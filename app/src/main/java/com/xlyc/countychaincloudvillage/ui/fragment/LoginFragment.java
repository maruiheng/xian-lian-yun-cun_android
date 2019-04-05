package com.xlyc.countychaincloudvillage.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.model.response.LoginResponse;
import com.xlyc.countychaincloudvillage.presenter.LoginPresenter;
import com.xlyc.countychaincloudvillage.presenter.view.ILoginView;
import com.xlyc.countychaincloudvillage.ui.widget.MyToast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends DialogFragment implements ILoginView {

    @Bind(R.id.login_phone)
    EditText loginPhone;
    @Bind(R.id.login_password)
    EditText loginPassword;
    @Bind(R.id.login)
    Button login;

    @Bind(R.id.register)
    TextView register;
    @Bind(R.id.fotget_password)
    TextView fotget_password;
    @Bind(R.id.login_qq)
    ImageView login_qq;
    @Bind(R.id.login_wechat)
    ImageView login_wechat;

    LoginPresenter loginPresenter = new LoginPresenter(this);


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            //添加动画
            dialog.getWindow().setWindowAnimations(R.style.dialogSlideAnim);
        }
        return inflater.inflate(R.layout.fragment_login, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        loginPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    Log.e("abc", "et1获取到焦点了。。。。。。");
                } else {
                    Log.e("abc", "et1失去焦点了。。。。。。");
                    String s = loginPhone.getText().toString();
//
                }
            }
        });
    }


    @OnClick({R.id.login, R.id.register, R.id.fotget_password, R.id.login_qq, R.id.login_wechat, R.id.login_close})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login:
                loginPresenter.login(getUserName(),getPassword());
                break;
            case R.id.register:
                showRegister();
                break;
            case R.id.fotget_password:
                showForget();
                break;
            case R.id.login_qq:
                break;
            case R.id.login_wechat:
                break;
            case R.id.login_close:
                dismiss();
                break;

        }
    }


    @Override
    public String getUserName() {
        return loginPhone.getText().toString();
    }

    @Override
    public String getPassword() {
        return loginPassword.getText().toString();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void loginSuccess(LoginResponse loginResponse) {
        MyToast.showToast(getContext(),loginResponse.getRepalceFlag()+"");
    }

    @Override
    public void showFailedError() {
        MyToast.showToast(getContext(),"请重试！");
    }

    @Override
    public void showRegister() {
        RegisterFragment registerFragment = new RegisterFragment();
        registerFragment.show(getChildFragmentManager(), "CHANNEL");
    }

    @Override
    public void showForget() {
        ForgetPwdFragment forgetPwdFragment = new ForgetPwdFragment();
        forgetPwdFragment.show(getChildFragmentManager(), "CHANNEL");
    }


}
