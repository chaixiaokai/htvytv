package com.example.lithography.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lithography.R;
import com.example.lithography.adapter.ReDianAdapter;
import com.example.lithography.bean.ReDianBean;
import com.example.lithography.iview.Iview;
import com.example.lithography.persenter.NewsPresenter;
import com.jude.swipbackhelper.SwipeBackHelper;

import java.util.HashMap;
import java.util.List;

public class RedaianzxActivity extends AppCompatActivity implements Iview{

    private NewsPresenter presenter;
    private RecyclerView redian_rv;
    private List<ReDianBean.RetBean.ListBean> list;
    private ReDianAdapter recycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redaianzx);
        redian_rv =(RecyclerView)findViewById(R.id.redian_rv);
        Intent intent = getIntent();
        String moreurl = intent.getStringExtra("name");
        Log.e("aaa", "onCreate: "+moreurl);
       String[] split = moreurl.split("=");
       String[] split1 = split[1].split("&");
       // Log.e("aaa", "onCreate: "+split[1].toString());
        HashMap<String, String> map = new HashMap<>();
        map.put("catalogId",split1[0]);
        map.put("information","null");
        presenter = new NewsPresenter();
        presenter.attacView(this);
        presenter.getData(map, "热点");
        LinearLayoutManager manager = new GridLayoutManager(this, 3 );
        redian_rv.setLayoutManager(manager);
    }

    @Override
    public void onSuccess(Object o, String tag) {
        if (tag.equals("热点")){
            ReDianBean bean=(ReDianBean)o;
            ReDianBean.RetBean ret = bean.getRet();
            list = ret.getList();

            recycleViewAdapter = new ReDianAdapter(RedaianzxActivity.this,list);
            redian_rv.setAdapter(recycleViewAdapter);
            //
            //adater点击事件 因为是在adapter中写的
            recycleViewAdapter.setRecycleOnClickListener(new ReDianAdapter.OnClickitemListener() {
                @Override
                public void onItemclick(int postion) {
                    //调到详情页  这个和详情页展示一样
                    Intent intent = new Intent(RedaianzxActivity.this, XiangqingActivity.class);
                    intent.putExtra("id", list.get(postion).getDataId());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onFailed(Exception e) {

    }


}
