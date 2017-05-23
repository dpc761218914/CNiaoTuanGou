package com.dpc.splash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    Handler mHander=new Handler();
    //判断用户是否是首次登录。
    private boolean isFrist=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //启动页面3秒钟
        mHander.postDelayed(new Runnable() {
            SharedPreferences sp=getPreferences(MODE_PRIVATE);
            boolean isFrist=sp.getBoolean("isFrist",true);
            @Override
            public void run() {
                Intent intent=new Intent();
                if(isFrist){
                    sp.edit().putBoolean("isFrist",false).commit();
                    //如果用户第一次安装应用，进入引导页面
                    intent.setClass(SplashActivity.this,GuideActivity.class);
                }else{
                    intent.setClass(SplashActivity.this,GuideActivity.class);
                }
                startActivity(intent);
                //设置页面之间的切换动画
                //overridePendingTransition();
                finish();
            }
        },3000);
    }
}
