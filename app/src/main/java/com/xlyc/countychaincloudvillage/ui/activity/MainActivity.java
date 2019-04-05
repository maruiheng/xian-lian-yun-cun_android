package com.xlyc.countychaincloudvillage.ui.activity;

import android.view.animation.Animation;

import com.chaychan.library.BottomBarItem;
import com.chaychan.library.BottomBarLayout;
import com.xlyc.countychaincloudvillage.R;
import com.xlyc.countychaincloudvillage.base.BaseActivity;
import com.xlyc.countychaincloudvillage.base.BaseFragment;
import com.xlyc.countychaincloudvillage.base.BasePresenter;
import com.xlyc.countychaincloudvillage.model.event.TabRefreshCompletedEvent;
import com.xlyc.countychaincloudvillage.model.event.TabRefreshEvent;
import com.xlyc.countychaincloudvillage.ui.adapter.MainTabAdapter;
import com.xlyc.countychaincloudvillage.ui.fragment.HomeFragment;
import com.xlyc.countychaincloudvillage.ui.fragment.MicroFragment;
import com.xlyc.countychaincloudvillage.ui.fragment.MineFragment;
import com.xlyc.countychaincloudvillage.ui.fragment.VideoFragment;
import com.xlyc.uikit.NoScrollViewPager;
import com.xlyc.uikit.statusbar.Eyes;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import cn.jzvd.Jzvd;

public class MainActivity extends BaseActivity {

    @Bind(R.id.vp_content)
    NoScrollViewPager mVpContent;

    @Bind(R.id.bottom_bar)
    BottomBarLayout mBottomBarLayout;

    private List<BaseFragment> mFragments;
    private MainTabAdapter mTabAdapter;

    private int[] mStatusColors = new int[]{
            R.color.color_D33D3C,
            R.color.color_BDBDBD,
            R.color.color_BDBDBD,
    };

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public boolean enableSlideClose() {
        return false;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        mFragments = new ArrayList<>(4);
        mFragments.add(new HomeFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new MicroFragment());
        mFragments.add(new MineFragment());
    }

    @Override
    public void initListener() {
        mTabAdapter = new MainTabAdapter(mFragments, getSupportFragmentManager());
        mVpContent.setAdapter(mTabAdapter);
        mVpContent.setOffscreenPageLimit(mFragments.size());
        mBottomBarLayout.setViewPager(mVpContent);
        //设置条目点击的监听
        mBottomBarLayout.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
            @Override
            public void onItemSelected(BottomBarItem bottomBarItem, int position) {
                setStatusBarColor(position);//设置状态栏颜色

                Jzvd.releaseAllVideos();//底部页签切换或者是下拉刷新，释放资源

                if (position == 0 || position == 1) {
                    //如果点击的是首页
                    if (mBottomBarLayout.getCurrentItem() == position) {
                        //如果当前页码和点击的页码一致,进行下拉刷新
                        String channelCode = "";
                        if (position == 0) {
                            channelCode = ((HomeFragment) mFragments.get(0)).getCurrentChannelCode();//获取到首页当前显示的fragment的频道
                        } else {
                            channelCode = ((VideoFragment) mFragments.get(1)).getCurrentChannelCode();//获取到视频当前显示的fragment的频道
                        }
                        postTabRefreshEvent(bottomBarItem, position, channelCode);//发送下拉刷新的事件
                    }
                    return;
                }

                //如果点击了其他条目
                BottomBarItem bottomItem = mBottomBarLayout.getBottomItem(0);
                bottomItem.setIconSelectedResourceId(R.mipmap.tab_home_selected);//更换为原来的图标

                cancelTabLoading(bottomItem);//停止旋转动画
            }
        });
    }

    private void setStatusBarColor(int position) {
        if (position == 3){
            //如果是我的页面，状态栏设置为透明状态栏
            Eyes.translucentStatusBar(MainActivity.this,true);
        }else{
            Eyes.setStatusBarColor(MainActivity.this, com.xlyc.countychaincloudvillage.utils.UIUtils.getColor(mStatusColors[position]));
        }
    }

    private void postTabRefreshEvent(BottomBarItem bottomBarItem, int position, String channelCode) {
        TabRefreshEvent event = new TabRefreshEvent();
        event.setChannelCode(channelCode);
        event.setBottomBarItem(bottomBarItem);
        event.setHomeTab(position == 0);
        EventBus.getDefault().post(event);//发送下拉刷新事件
    }

    /**
     * 停止首页页签的旋转动画
     */
    private void cancelTabLoading(BottomBarItem bottomItem) {
        Animation animation = bottomItem.getImageView().getAnimation();
        if (animation != null) {
            animation.cancel();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRefreshCompletedEvent(TabRefreshCompletedEvent event) {
        //接收到刷新完成的事件，取消旋转动画，更换底部首页页签图标
        BottomBarItem bottomItem = mBottomBarLayout.getBottomItem(0);

        cancelTabLoading(bottomItem);//停止旋转动画

        bottomItem.setIconSelectedResourceId(R.mipmap.tab_home_selected);//更换成首页原来图标
        bottomItem.setStatus(true);//刷新图标
    }

    ;

    @Override
    protected void onStart() {
        super.onStart();
        registerEventBus(MainActivity.this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterEventBus(MainActivity.this);
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }
}
