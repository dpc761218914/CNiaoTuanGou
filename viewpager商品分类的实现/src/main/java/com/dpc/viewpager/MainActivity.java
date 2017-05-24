package com.dpc.viewpager;

import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dpc.adapter.MyGridAdapter;
import com.dpc.adapter.MyPagerAdapter;
import com.dpc.entity.HomeIconInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<View> mViews = new ArrayList<>();
    /**
     * gridView两页的数据
     */
    private List<HomeIconInfo> mPagerOneData = new ArrayList<>();
    private List<HomeIconInfo> mPagerTwoData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initGridView();
    }

    /***
     * 初始化gridview的数据
     */
    private void initData() {
        String[] iconName = getResources().getStringArray(R.array.home_bar_labels);
        TypedArray typedArray = getResources().obtainTypedArray(R.array.home_bar_icon);

        for (int i = 0; i < iconName.length; i++) {
            if (i < 8) {
                mPagerOneData.add(new HomeIconInfo(iconName[i], typedArray.getResourceId(i, 0)));
            } else {
                mPagerTwoData.add(new HomeIconInfo(iconName[i], typedArray.getResourceId(i, 0)));
            }
        }
    }

    /***
     * 初始化gridview
     */
    private void initGridView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        View pagerOne = getLayoutInflater().inflate(R.layout.home_gridview, null);
        GridView gridView01 = (GridView) pagerOne.findViewById(R.id.gridView);
        gridView01.setAdapter(new MyGridAdapter(mPagerOneData, MainActivity.this));
        gridView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });


        View pagerTwo = getLayoutInflater().inflate(R.layout.home_gridview, null);
        GridView gridView02 = (GridView) pagerTwo.findViewById(R.id.gridView);
        gridView02.setAdapter(new MyGridAdapter(mPagerTwoData,MainActivity.this));
        gridView02.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        mViews.add(pagerOne);
        mViews.add(pagerTwo);
        viewPager.setAdapter(new MyPagerAdapter(mViews));

    }
}
