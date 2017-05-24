package com.dpc.tabfragmenttabhost;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private Class[] fragments=new Class[]{MainFragment.class,AroundFragment.class,
            MineFragment.class, MoreFragment.class
    };
    //设置底部切换图片
    private int[] imgSelectors=new int[]{
      R.drawable.ic_home_tab_index_selector,
      R.drawable.ic_home_tab_near_selector,
      R.drawable.ic_home_tab_my_selector,
      R.drawable.ic_home_tab_more_selector
    };
    private String[] textSelectors=new String[]{
            "首页","周边","我的","更多"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTabHost tabHost=(FragmentTabHost)findViewById(R.id.tabHost);
        tabHost.setup(MainActivity.this,getSupportFragmentManager(),android.R.id.tabcontent);
        for(int i=0;i<fragments.length;i++){
            View inflate=getLayoutInflater().inflate(R.layout.tab_item,null);
            ImageView imageView=(ImageView)inflate.findViewById(R.id.iv);
            TextView textView=(TextView)inflate.findViewById(R.id.tv);
            imageView.setImageResource(imgSelectors[i]);
            textView.setText(textSelectors[i]);
            //newTabSpec需要加上i进行标识，不然无法实现切换。
            tabHost.addTab(tabHost.newTabSpec(""+i).setIndicator(inflate),fragments[i],null);
        }
    }
}
