package com.example.lithography.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.lithography.R;
import com.example.lithography.adapter.FAdapter;
import com.example.lithography.bean.XiangqingBean;
import com.example.lithography.fragment2.JIanjieFragment;
import com.example.lithography.fragment2.PinglunFragment;
import com.example.lithography.iview.Iview;
import com.example.lithography.persenter.NewsPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

public class XiangqingActivity extends AppCompatActivity implements Iview{

    private ViewPager vp;
    private TextView text1;
    private NewsPresenter presenter;
    private ArrayList<Fragment> fragments;
    private IjkVideoView viewById;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        vp = (ViewPager) findViewById(R.id.vp);
        text1 =(TextView)findViewById(R.id.text1);
        viewById = (IjkVideoView) findViewById(R.id.ijkplay);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        HashMap<String,String> map=new HashMap<>();
        map.put("mediaId",id);
        presenter = new NewsPresenter();
        presenter.attacView(this);
        presenter.getData(map,"详情");
        fragments = new ArrayList<>();
        fragments.add(new JIanjieFragment());
        fragments.add(new PinglunFragment(id));

        FAdapter fAdapter = new FAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(fAdapter);
    }

    @Override
    public void onSuccess(Object o, String tag) {
        if (tag.equals("详情")) {
            XiangqingBean bean = (XiangqingBean) o;
            text1.setText(bean.getRet().getTitle());
            String hdurl = bean.getRet().getHDURL();
            //发送
            EventBus.getDefault().post(bean);

            if(hdurl!=null){
                String url = hdurl;
                AndroidMediaController androidMediaController = new AndroidMediaController(this, false);
                viewById.setMediaController(androidMediaController);
                viewById.setVideoURI(Uri.parse(url));
                viewById.start();
            }
        }
    }

    @Override
    public void onFailed(Exception e) {

    }
}
