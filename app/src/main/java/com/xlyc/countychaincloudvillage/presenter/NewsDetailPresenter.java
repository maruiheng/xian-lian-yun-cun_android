package com.xlyc.countychaincloudvillage.presenter;


import com.xlyc.countychaincloudvillage.base.BasePresenter;
import com.xlyc.countychaincloudvillage.constants.Constant;
import com.xlyc.countychaincloudvillage.presenter.view.INewsDetailView;

/**
 * @author ChayChan
 * @description: 新闻详情获取数据的presenter
 * @date 2017/6/28  15:42
 */

public class NewsDetailPresenter extends BasePresenter<INewsDetailView> {

    public NewsDetailPresenter(INewsDetailView view) {
        super(view);
    }

    public void getComment(String groupId, String itemId, int pageNow) {
        int offset = (pageNow - 1) * Constant.COMMENT_PAGE_SIZE;
//        addSubscription(mApiService.getComment(groupId, itemId, offset + "", String.valueOf(Constant.COMMENT_PAGE_SIZE)), new Subscriber<CommentResponse>() {
//            @Override
//            public void onCompleted() {
//            }
//
//            @Override
//            public void onError(Throwable e) {
//               e.printStackTrace();
//                KLog.e(e.getLocalizedMessage());
//                mView.onError();
//            }
//
//            @Override
//            public void onNext(CommentResponse response) {
//                mView.onGetCommentSuccess(response);
//            }
//
//        });
    }

    public void getNewsDetail(String url) {
//        addSubscription(mApiService.getNewsDetail(url), new SubscriberCallBack<NewsDetail>() {
//
//            @Override
//            protected void onSuccess(NewsDetail response) {
//                mView.onGetNewsDetailSuccess(response);
//            }
//
//            @Override
//            protected void onError() {
//                mView.onError();
//            }
//        });
    }
}
