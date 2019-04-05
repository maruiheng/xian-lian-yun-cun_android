package com.xlyc.countychaincloudvillage.api;

import com.socks.library.KLog;
import com.xlyc.countychaincloudvillage.model.response.BaseReponse;
import com.xlyc.countychaincloudvillage.utils.UIUtils;

import rx.Observer;

public abstract class MySubscriptionCallBack<T> implements Observer<BaseReponse<T>> {

    protected abstract void onSuccess(T response);
    protected abstract void onError();

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        KLog.e(e.getLocalizedMessage());
        onError();
    }

    @Override
    public void onNext(BaseReponse<T> response) {
        if (response.code == 0) {
            onSuccess((T) response.data);

        }
        UIUtils.showToast(response.message);
    }
}
