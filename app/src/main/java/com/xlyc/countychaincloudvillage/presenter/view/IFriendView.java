package com.xlyc.countychaincloudvillage.presenter.view;

import com.xlyc.countychaincloudvillage.model.response.FriendCircleListResponse;

public interface IFriendView {

    void releaseInfo();

    void shareItem(String id);

    void giveLike(String id);

    void comments(String id);

    void showBigImg(String id);

    void playVideo(String id);

    void getListSuccess(FriendCircleListResponse response);

    void getListError();

}
