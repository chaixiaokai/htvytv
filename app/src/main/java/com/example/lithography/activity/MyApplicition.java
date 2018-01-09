package com.example.lithography.activity;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 柴晓凯 on 2018/1/3.
 */

public class MyApplicition extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化.别忘了在清单文件注册
        Fresco.initialize(this);
    }
}
