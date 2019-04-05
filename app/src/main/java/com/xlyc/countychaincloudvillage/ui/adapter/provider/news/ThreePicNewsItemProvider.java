package com.xlyc.countychaincloudvillage.ui.adapter.provider.news;

import com.chad.library.adapter.base.BaseViewHolder;
import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.model.entity.News;
import com.xlyc.countychaincloudvillage.ui.adapter.NewsListAdapter;
import com.xlyc.countychaincloudvillage.utils.GlideUtils;


/**
 * @author ChayChan
 * @description: 三张图片布局(文章、广告)
 * @date 2018/3/22  14:36
 */
public class ThreePicNewsItemProvider extends BaseNewsItemProvider {

    public ThreePicNewsItemProvider(String channelCode) {
        super(channelCode);
    }

    @Override
    public int viewType() {
        return NewsListAdapter.THREE_PICS_NEWS;
    }

    @Override
    public int layout() {
        return R.layout.item_three_pics_news;
    }

    @Override
    protected void setData(BaseViewHolder helper, News news) {
        //三张图片的新闻
        GlideUtils.load(mContext, news.image_list.get(0).url, helper.getView(R.id.iv_img1));
        GlideUtils.load(mContext, news.image_list.get(1).url, helper.getView(R.id.iv_img2));
        GlideUtils.load(mContext, news.image_list.get(2).url, helper.getView(R.id.iv_img3));
    }

}
