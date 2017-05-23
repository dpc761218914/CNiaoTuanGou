package com.dpc.splash;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

//引导界面
public class GuideActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    /*
    * 存放引导图片,这里需要注意的时候高清图片不能放在drawable中，需要放在mipmap中，
    * 这个问题折腾了我好久，之前在eclipse中是没有mipmap的。
    * */
    int[] imgRes=new int[]{
            R.mipmap.guide_1,
            R.mipmap.guide_2,
            R.mipmap.guide_3,
            R.mipmap.guide_4
    };
    //构建视图列表
    private List<View> mViewList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        mViewPager=(ViewPager)findViewById(R.id.viewPager);
        myPagerAdapter mAdapter=new myPagerAdapter();
        mViewPager.setAdapter(mAdapter);
    }

    /*初始化数据*/
    private void initData(){
        for(int i=0;i<imgRes.length;i++){
            View inflate= getLayoutInflater().inflate(R.layout.guide_item,null);
            ImageView ivGuide=(ImageView)inflate.findViewById(R.id.iv_guide);
            ivGuide.setBackgroundResource(imgRes[i]);
            mViewList.add(inflate);
        }
    }
    /*
    * 引导页面ViewPager适配器
    *
    * */
    class myPagerAdapter extends PagerAdapter{
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            View view=mViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            //官方推荐写法
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }
    }
}
