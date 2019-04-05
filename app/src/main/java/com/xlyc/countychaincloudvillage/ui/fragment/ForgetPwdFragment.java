package com.xlyc.countychaincloudvillage.ui.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.model.request.ForgetPwdRequest;
import com.xlyc.countychaincloudvillage.model.request.SmsRequtst;
import com.xlyc.countychaincloudvillage.presenter.FoegetPwdPresenter;
import com.xlyc.countychaincloudvillage.presenter.view.IForgetPwdView;
import com.xlyc.countychaincloudvillage.ui.widget.MyToast;
import com.xlyc.countychaincloudvillage.utils.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgetPwdFragment extends DialogFragment implements IForgetPwdView {

    @Bind(R.id.phone)
    EditText phone;
    @Bind(R.id.forget_code)
    EditText forgetCode;
    @Bind(R.id.new_password)
    EditText newPassword;
    @Bind(R.id.confirm_password)
    EditText confirmPassword;
    @Bind(R.id.forget_close)
    ImageView forget_close;
    @Bind(R.id.submit)
    Button submit;
    @Bind(R.id.get_code)
    Button get_code;

    FoegetPwdPresenter foegetPwdPresenter = new FoegetPwdPresenter(this);

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
        return inflater.inflate(R.layout.fragment_forget_password, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    Log.e("abc", "et1获取到焦点了。。。。。。");
                } else {
                    Log.e("abc", "et1失去焦点了。。。。。。");
                    String s = phone.getText().toString();
//
                }
            }
        });
    }


    @OnClick({R.id.forget_close, R.id.submit, R.id.get_code})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.forget_close:
                close();
                break;
            case R.id.submit:
                submit();
                break;
            case R.id.get_code:
                getsmsCode();
                break;

        }
    }

    @Override
    public void showToast(String msg) {
        MyToast.showToast(getContext(), msg);
    }

    @Override
    public void getsmsCode() {
        if (TextUtils.isEmpty(getNum())) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.phone_null));
            return;
        }
        SmsRequtst smsRequtst = new SmsRequtst();
        smsRequtst.setType("1");
        smsRequtst.setPhone(getNum());
        smsRequtst.setCountryCode("86");
        foegetPwdPresenter.getCode(smsRequtst);
    }

    @Override
    public void submit() {
        if (TextUtils.isEmpty(getNum())) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.phone_null));
            return;
        } else if (TextUtils.isEmpty(getSmsCode())) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.code_null));
            return;
        } else if (TextUtils.isEmpty(getPwd())) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.password_null));
            return;
        } else if (TextUtils.isEmpty(confirmPassword.getText().toString())) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.password_null));
            return;
        } else if (!TextUtils.equals(getPwd(), confirmPassword.getText().toString())) {
            MyToast.showToast(getActivity(), Utils.getString(getActivity(), R.string.compare_pass));
            return;
        }
        ForgetPwdRequest request = new ForgetPwdRequest();
        request.setAccount(getNum());
        request.setCountyCode("86");
        request.setSmsCode(getSmsCode());
        request.setPasswd(getPwd());
        foegetPwdPresenter.submist(request);
    }

    @Override
    public void close() {
        dismiss();
    }

    @Override
    public String getNum() {
        return phone.getText().toString();
    }

    @Override
    public String getSmsCode() {
        return forgetCode.getText().toString();
    }

    @Override
    public String getPwd() {
        return newPassword.getText().toString();
    }
}
