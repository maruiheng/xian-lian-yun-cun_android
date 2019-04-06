package com.xlyc.countychaincloudvillage.presenter;

import com.xlyc.countychaincloudvillage.api.MySubscriptionCallBack;
import com.xlyc.countychaincloudvillage.base.BasePresenter;
import com.xlyc.countychaincloudvillage.model.request.FriendCircleListRequest;
import com.xlyc.countychaincloudvillage.model.response.FriendCircleListResponse;
import com.xlyc.countychaincloudvillage.presenter.view.IFriendView;

public class IFriendPresenter extends BasePresenter<IFriendView> {

    public IFriendPresenter(IFriendView view) {
        super(view);
    }


    public void getFriendCaircleList(FriendCircleListRequest request) {
        addSubscription(mApiService.getFriendCaircleList(request), new MySubscriptionCallBack<FriendCircleListResponse>() {
            @Override
            protected void onSuccess(FriendCircleListResponse response) {
                mView.getListSuccess(response);
            }

            @Override
            protected void onError() {
                mView.getListError();
            }
        });
    }






}
