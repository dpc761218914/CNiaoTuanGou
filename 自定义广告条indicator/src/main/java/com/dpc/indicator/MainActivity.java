package com.dpc.indicator;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<View> mViews = new ArrayList<>();
    private indicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        ViewPager viewPager=(ViewPager)findViewById(R.id.viewPage);
        viewPager.setAdapter(new myPagerAdapter());
        viewPager.setOnPageChangeListener(new MyPagerListner());
        mIndicator = (indicator) findViewById(R.id.myindicator);

    }

    private void initData(){
        for (int i = 0; i < 4; i++) {
            View inflate = getLayoutInflater().inflate(R.layout.pager_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv);
            imageView.setImageResource(R.mipmap.ic_launcher);
            mViews.add(inflate);
        }
    }

    //
    class MyPagerListner implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            mIndicator.setOffset(position,positionOffset);
        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


    class myPagerAdapter extends PagerAdapter{
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            position %= 4;
            View view=mViews.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            position %= 4;
            container.removeView(mViews.get(position));
        }

        @Override
        public int getCount() {
            return 1000;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }
}
