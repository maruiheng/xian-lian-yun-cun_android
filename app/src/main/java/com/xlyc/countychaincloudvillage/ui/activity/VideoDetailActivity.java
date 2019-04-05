package com.xlyc.countychaincloudvillage.ui.activity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.widget.ImageView;

import com.socks.library.KLog;
import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.model.entity.NewsDetail;
import com.xlyc.countychaincloudvillage.ui.widget.NewsDetailHeaderView;
import com.xlyc.countychaincloudvillage.utils.MyJZVideoPlayerStandard;
import com.xlyc.countychaincloudvillage.utils.UIUtils;
import com.xlyc.countychaincloudvillage.utils.VideoPathDecoder;
import com.xlyc.uikit.statusbar.Eyes;

import butterknife.Bind;
import butterknife.OnClick;
import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

import static android.content.Context.SENSOR_SERVICE;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * @author ChayChan
 * @description: 视频新闻
 * @date 2017/7/4  16:51
 */

public class VideoDetailActivity extends NewsDetailBaseActivity {

    @Bind(R.id.video_player)
    MyJZVideoPlayerStandard mVideoPlayer;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    private SensorManager mSensorManager;
    private Jzvd.JZAutoFullscreenListener mSensorEventListener;
    private long mProgress;
    private String mVideoUrl;

    @Override
    public void initView() {
        super.initView();
        Eyes.setStatusBarColor(this, UIUtils.getColor(android.R.color.black));
    }

    @Override
    public void initData() {
        super.initData();
        mProgress = getIntent().getLongExtra(PROGRESS, 0);
        mVideoUrl = getIntent().getStringExtra(VIDEO_URL);
    }

    @Override
    public void initListener() {
        super.initListener();
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensorEventListener = new Jzvd.JZAutoFullscreenListener();

        mVideoPlayer.setAllControlsVisiblity(GONE, GONE, VISIBLE, GONE, VISIBLE, VISIBLE, GONE);
        mVideoPlayer.titleTextView.setVisibility(GONE);
    }

    @Override
    protected int getViewContentViewId() {
        return R.layout.activity_video_detail;
    }

    @Override
    public void onGetNewsDetailSuccess(NewsDetail newsDetail) {
        KLog.e("onGetNewsDetailSuccess", newsDetail.url);
        newsDetail.content = "";
        mHeaderView.setDetail(newsDetail, new NewsDetailHeaderView.LoadWebListener() {
            @Override
            public void onLoadFinished() {
                //加载完成后，显示内容布局
                mStateView.showContent();
            }
        });

        if (TextUtils.isEmpty(mVideoUrl)) {
            KLog.e("没有视频地址，解析视频");
            //如果列表页还没有获取到解析的视频地址，则详情页需要解析视频
            VideoPathDecoder decoder = new VideoPathDecoder() {
                @Override
                public void onSuccess(String url) {
                    KLog.e("onGetNewsDetailSuccess", url);
                    UIUtils.postTaskSafely(new Runnable() {
                        @Override
                        public void run() {
                            playVideo(url, newsDetail);
                        }
                    });
                }

                @Override
                public void onDecodeError(String errorMsg) {
                    UIUtils.showToast(errorMsg);
                }
            };
            decoder.decodePath(newsDetail.url);
        } else {
            //如果有视频地址，则直接播放
            KLog.e("有视频地址，则直接播放");
            playVideo(mVideoUrl, newsDetail);
        }
    }

    private void playVideo(String url, NewsDetail newsDetail) {
        mVideoPlayer.setUp(url, newsDetail.title, JzvdStd.SCREEN_WINDOW_LIST);
        mVideoPlayer.seekToInAdvance = mProgress;//设置进度
        mVideoPlayer.startVideo();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mSensorEventListener);
        Jzvd.releaseAllVideos();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometerSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(mSensorEventListener, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        postVideoEvent(true);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        postVideoEvent(true);
    }
}
