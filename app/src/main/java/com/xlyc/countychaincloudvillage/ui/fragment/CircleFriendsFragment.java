package com.xlyc.countychaincloudvillage.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.base.BaseFragment;
import com.xlyc.countychaincloudvillage.base.BasePresenter;
import com.xlyc.countychaincloudvillage.model.request.FriendCircleListRequest;
import com.xlyc.countychaincloudvillage.model.response.FriendCircleListResponse;
import com.xlyc.countychaincloudvillage.presenter.IFriendPresenter;
import com.xlyc.countychaincloudvillage.presenter.view.IFriendView;
import com.xlyc.countychaincloudvillage.utils.DialogUtil;
import com.xlyc.uikit.powerfulrecyclerview.PowerfulRecyclerView;
import com.xlyc.uikit.refreshlayout.BGARefreshLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CircleFriendsFragment extends BaseFragment implements IFriendView {

    @Bind(R.id.cfRecycleView)
    PowerfulRecyclerView cfRecycleView;
    @Bind(R.id.cfRefreshLayout)
    BGARefreshLayout cfRefreshLayout;
    private int page = 1;
    private int rows = 10;

    @Override
    protected BasePresenter createPresenter() {
        return new IFriendPresenter(this);
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_circlefriends;
    }

    @Override
    protected void loadData() {
        FriendCircleListRequest request = new FriendCircleListRequest();
        request.setAreaCode("areaCode");
        request.setCustId("custId");
        request.setPage(page);
        request.setRows(rows);

    }


    @OnClick(R.id.cfTopRelease)
    public void onClick() {
        releaseInfo();
    }

    @Override
    public void releaseInfo() {
        DialogUtil.showReleaseSelectBtmDialog(getActivity(), new DialogUtil.OnTypeSelectListener() {
            @Override
            public void onPhotograph() {

            }

            @Override
            public void onShootVideo() {

            }

            @Override
            public void onPhotoAlbum() {

            }
        });
    }

    @Override
    public void shareItem(String id) {

    }

    @Override
    public void giveLike(String id) {

    }

    @Override
    public void comments(String id) {

    }

    @Override
    public void showBigImg(String id) {

    }

    @Override
    public void playVideo(String id) {

    }

    @Override
    public void getListSuccess(FriendCircleListResponse response) {

    }

    @Override
    public void getListError() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
