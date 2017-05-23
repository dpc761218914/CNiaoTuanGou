package com.dpc.banner;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    //图片资源
    private int [] imgResID=new int[]{
            R.drawable.banner01,
            R.drawable.banner02,
            R.drawable.banner03
    };
    private Handler handler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=(ViewPager) findViewById(R.id.vp_banner);
        viewPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
        autoScorll();

    }

    //自动滚动
    private void autoScorll(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int currentItem=viewPager.getCurrentItem();
                viewPager.setCurrentItem(currentItem+1);
                //让hander循环执行
                handler.postDelayed(this,2000);
            }
        },2000);
    }

    class myPagerAdapter extends FragmentPagerAdapter {
        public myPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        //返回fragment视图
        @Override
        public Fragment getItem(int position) {
            //需要模数组长度，不然没法处理。
            position%=imgResID.length;
            BannerFragment fragment=new BannerFragment();
            fragment.setImg(imgResID[position]);
            return fragment;
        }

        @Override
        public int getCount() {
            //为了循环滚动，不能写成固定的。
            return 10000;
        }
    }
}
