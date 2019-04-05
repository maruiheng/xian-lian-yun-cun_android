package com.xlyc.countychaincloudvillage.presenter.view;

import com.xlyc.countychaincloudvillage.model.entity.News;

import java.util.List;

/**
 * @description: 获取各种频道广告的View回调接口
 */

public interface lNewsListView {

    void onGetNewsListSuccess(List<News> newList, String tipInfo);

    void  onError();
}
