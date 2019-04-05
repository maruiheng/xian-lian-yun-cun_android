package com.xlyc.countychaincloudvillage.api;

import android.text.TextUtils;

import com.socks.library.KLog;
import com.xlyc.countychaincloudvillage.model.response.ResultResponse;
import com.xlyc.countychaincloudvillage.utils.UIUtils;

import rx.Subscriber;

/**
 * @description: 抽取CallBack
 */
public abstract class SubscriberCallBack<T> extends Subscriber<ResultResponse<T>> {

    @Override
    public void onNext(ResultResponse response) {
        boolean isSuccess = (!TextUtils.isEmpty(response.message) && response.message.equals("success"))
                || !TextUtils.isEmpty(response.success) && response.success.equals("true");
        if (isSuccess) {
            onSuccess((T) response.data);
        } else {
            UIUtils.showToast(response.message);
            onFailure(response);
        }
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        KLog.e(e.getLocalizedMessage());
        onError();
    }

    protected abstract void onSuccess(T response);
    protected abstract void onError();

    protected void onFailure(ResultResponse response) {
    }

}
