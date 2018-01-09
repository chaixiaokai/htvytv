package com.example.lithography.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.lithography.R;
import com.example.lithography.activity.AlphaTitleScrollView;
import com.example.lithography.activity.XiangqingActivity;
import com.example.lithography.adapter.RecycleViewAdapter;
import com.example.lithography.bean.Dabean;
import com.example.lithography.bean.Img;
import com.example.lithography.imageloder.ImgApp;
import com.example.lithography.iview.Iview;
import com.example.lithography.persenter.NewsPresenter;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 柴晓凯 on 2018/1/1.
 */

public class OneFragment extends Fragment implements Iview {

    @BindView(R.id.als)
    AlphaTitleScrollView als;
    Unbinder unbinder;
    @BindView(R.id.re)
    RelativeLayout re;
    private Banner ban;
    private NewsPresenter presenter;
    List<String> lists = new ArrayList<>();
    List<Img> lists1 = new ArrayList<>();
    private RecyclerView rv;
    private RecycleViewAdapter recycleViewAdapter;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.onefragment, container, false);
        ban = (Banner) view.findViewById(R.id.ban);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        unbinder = ButterKnife.bind(this, view);
        als.set(new AlphaTitleScrollView.onScrollChangedListener() {
            @Override
            public void Changed(int l, int t, int oldl, int oldt) {
                if (t > 100) {
                    re.setVisibility(View.VISIBLE);
                } else {
                    re.setVisibility(View.GONE);
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HashMap<String, String> map = new HashMap<>();
        presenter = new NewsPresenter();
        presenter.attacView(this);
        presenter.getData(map, "轮播");
    }


    @Override
    public void onSuccess(Object o, String tag) {
        if (tag.equals("轮播")) {
            Dabean bean = (Dabean) o;
            Dabean.RetBean ret = bean.getRet();
            List<Dabean.RetBean.ListBean> list = ret.getList();
            Dabean.RetBean.ListBean listBean = list.get(0);
            final List<Dabean.RetBean.ListBean.ChildListBean> childList = listBean.getChildList();
            for (int i = 0; i < childList.size(); i++) {
                String pic = childList.get(i).getPic();
                lists.add(pic);
            }
            ban.setImageLoader(new ImgApp());//引用ImgApp,加载里面的东西
            ban.setImages(lists);
            ban.isAutoPlay(true);
            ban.setDelayTime(2000);
            ban.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                    String dataId = childList.get(position).getDataId();
                    intent.putExtra("id",dataId);
                    startActivity(intent);
                }
            });
            ban.start();

            List<Dabean.RetBean.ListBean.ChildListBean> childList1 = bean.getRet().getList().get(4).getChildList();
            for (int j = 0; j < childList1.size(); j++) {
                String title = childList1.get(j).getTitle();
                String pic = childList1.get(j).getPic();
                lists1.add(new Img(title, pic));
            }

            LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rv.setLayoutManager(manager);
            recycleViewAdapter = new RecycleViewAdapter(getActivity(), lists1);
            rv.setAdapter(recycleViewAdapter);
        }
    }

    @Override
    public void onFailed(Exception e) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
