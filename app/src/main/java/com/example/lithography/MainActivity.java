package com.example.lithography;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.lithography.fragment.FourFragment;
import com.example.lithography.fragment.OneFragment;
import com.example.lithography.fragment.ThreeFragment;
import com.example.lithography.fragment.TwoFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class MainActivity extends AppCompatActivity {

    private BottomTabBar mb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        mb =(BottomTabBar)findViewById(R.id.bottom_tab_bar);
        mb.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(14)
                .setTabPadding(4,6,10)
                .setTabBarBackgroundResource(R.mipmap.bottom_bg)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("热点",R.drawable.found, OneFragment.class)
                .addTabItem("专题",R.drawable.special, TwoFragment.class)
                .addTabItem("发现",R.drawable.fancy, ThreeFragment.class)
                .addTabItem("我的",R.drawable.my, FourFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}
