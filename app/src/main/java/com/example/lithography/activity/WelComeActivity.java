package com.example.lithography.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.lithography.MainActivity;
import com.example.lithography.R;

public class WelComeActivity extends AppCompatActivity {

    private ImageView welcome_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wel_come);
        welcome_img =(ImageView) findViewById(R.id.welcome_img);
        AnimationSet animationSet = new AnimationSet(false);
        Animation animation = new ScaleAnimation(1f, 1.1f, 1f, 1.1f, Animation.RELATIVE_TO_SELF, 1f, Animation.RELATIVE_TO_SELF, 1f);
        animation.setDuration(3000);
        animationSet.addAnimation(animation);
        welcome_img.setAnimation(animationSet);
        animationSet.start();//开始

        //设置动画的监听事件
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {//结束的时候跳转
                Intent intent = new Intent(WelComeActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
