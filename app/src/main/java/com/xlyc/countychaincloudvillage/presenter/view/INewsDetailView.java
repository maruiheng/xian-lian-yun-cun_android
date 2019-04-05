package com.xlyc.countychaincloudvillage.presenter.view;


import com.xlyc.countychaincloudvillage.model.entity.NewsDetail;
import com.xlyc.countychaincloudvillage.model.response.CommentResponse;

/**
 * @author ChayChan
 * @description: 新闻详情的回调
 * @date 2017/6/28  15:41
 */

public interface INewsDetailView {

    void onGetNewsDetailSuccess(NewsDetail newsDetail);

    void onGetCommentSuccess(CommentResponse response);

    void onError();
}
