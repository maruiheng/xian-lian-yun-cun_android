package com.xlyc.countychaincloudvillage.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;


import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.model.request.RegisterRequest;
import com.xlyc.countychaincloudvillage.model.request.SmsRequtst;
import com.xlyc.countychaincloudvillage.model.response.LoginResponse;
import com.xlyc.countychaincloudvillage.presenter.RegisterPresenter;
import com.xlyc.countychaincloudvillage.presenter.view.IRegisterView;
import com.xlyc.countychaincloudvillage.ui.widget.MyToast;
import com.xlyc.countychaincloudvillage.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterFragment extends DialogFragment implements IRegisterView {

    @Bind(R.id.phone)
    EditText phone;
    @Bind(R.id.register_code)
    EditText registerCode;
    @Bind(R.id.register_invite_code)
    EditText registerInviteCode;
    @Bind(R.id.register_password)
    EditText registerPassword;
    @Bind(R.id.confirm_password)
    EditText confirmPassword;
    @Bind(R.id.register_check)
    CheckBox registerCheck;

    // 判断是否选择同意协议
    private boolean isCheck;

    RegisterPresenter registerPresenter = new RegisterPresenter(this);

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(android.support.v4.app.DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            //添加动画
            dialog.getWindow().setWindowAnimations(R.style.dialogSlideAnim);
        }
        return inflater.inflate(R.layout.fragment_register, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);


    }

    @OnClick({R.id.register_close, R.id.go_login, R.id.get_code, R.id.register_check, R.id.register_prot, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_close:
                dismiss();
                break;
            case R.id.go_login:
                dismiss();
                break;
            case R.id.get_code:
                getCode();
                break;
            case R.id.register_check:
                checkProt();
                break;
            case R.id.submit:
                register();
                break;
            case R.id.register_prot:
//                gotoProt();
                break;
        }
    }

    /**
     * 协议
     */
    private void checkProt() {
        if (isCheck) {
            isCheck = false;
        } else {
            isCheck = true;
        }
    }

    /**
     * 获取验证码
     */
    private void getCode() {
        if (TextUtils.isEmpty(getnum())){
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.phone_null));
            return;
        }
        SmsRequtst smsRequtst = new SmsRequtst();
        smsRequtst.setPhone(getnum());
        smsRequtst.setCountryCode("86");
        smsRequtst.setType("0");
        registerPresenter.getSmsCode(smsRequtst);
    }


    @Override
    public String getnum() {
        return phone.getText().toString();
    }

    @Override
    public String getcode() {
        return registerCode.getText().toString();
    }

    @Override
    public String gettuijianCode() {
        return registerInviteCode.getText().toString();
    }

    @Override
    public String getPwd() {
        return registerPassword.getText().toString();
    }

    @Override
    public String getrePwd() {
        return confirmPassword.getText().toString();
    }

    @Override
    public boolean getIschick() {
        return registerCheck.isChecked();
    }

    @Override
    public void register() {
        String username = phone.getText().toString();
        String code = registerCode.getText().toString();
        String inviteCode = registerInviteCode.getText().toString();
        String password = registerPassword.getText().toString();
        String confirm_password = confirmPassword.getText().toString();
        boolean isCheck = registerCheck.isChecked();

        if (TextUtils.isEmpty(username)) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.phone_null));
        } else if (TextUtils.isEmpty(code)) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.code_null));
        } else if (TextUtils.isEmpty(password)) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.password_null));
        } else if (Utils.regPatternsPassword(getActivity(), password)) {
            return;
        } else if (!TextUtils.equals(password, confirm_password)) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.compare_pass));
        } else if (Utils.regPatternsPassword(getActivity(), password)) {
            return;
        } else if (!isCheck) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.isCheck));
            return;
        }
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setAccount(getnum());
        registerRequest.setPasswd(getPwd());
        registerRequest.setSmsCode(code);
        registerRequest.setCountryId(1);
        registerRequest.setCountryCode("86");
        registerRequest.setInviteCode(inviteCode);
        registerPresenter.register(registerRequest);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void getRegistercode() {

    }

    @Override
    public void RegisterSuccess(LoginResponse loginResponse) {
        MyToast.showToast(getContext(),"注册成功！");
        dismiss();
    }

    @Override
    public void showFailedError() {
        MyToast.showToast(getContext(),"注册失败！");
    }

    @Override
    public void close() {
        dismiss();
    }
}
