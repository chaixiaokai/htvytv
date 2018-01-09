package com.example.lithography.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lithography.R;
import com.example.lithography.activity.RedaianzxActivity;
import com.example.lithography.adapter.twoRecycleviewAdapter;
import com.example.lithography.bean.Dabean;
import com.example.lithography.iview.Iview;
import com.example.lithography.jiekou.FoundJk;
import com.example.lithography.persenter.NewsPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 柴晓凯 on 2018/1/1.
 */

public class TwoFragment extends Fragment implements Iview{

    private RecyclerView two_rv;
    private NewsPresenter presenter;
    List<Dabean.RetBean.ListBean> list=new ArrayList<>();
    private twoRecycleviewAdapter recycleViewAdapter;
    private List<Dabean.RetBean.ListBean> o1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.twofragment, container, false);
        two_rv =(RecyclerView)view.findViewById(R.id.two_rv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        HashMap<String, String> map = new HashMap<>();
        presenter = new NewsPresenter();
        presenter.attacView(this);
        presenter.getData(map, "轮播");
        LinearLayoutManager manager = new GridLayoutManager(getActivity(), 2);
        two_rv.setLayoutManager(manager);
    }

    @Override
    public void onSuccess(Object o, String tag) {
        if (tag.equals("轮播")){
            Dabean bean = (Dabean) o;
            Dabean.RetBean ret = bean.getRet();
            o1 = ret.getList();
            for (int i = 0; i < o1.size(); i++) {
                if (!(o1.get(i).getMoreURL().equals("")) && !(o1.get(i).getTitle().equals(""))) {
                    list.add(o1.get(i));
                }
        }
           //接口//
            recycleViewAdapter = new twoRecycleviewAdapter(getActivity(), list, new FoundJk() {
                @Override
                public void Chuanzhi(int position) {
                    String moreURL = list.get(position).getMoreURL();
                    //Log.e("ol", "Chuanzhi: "+moreURL.toString() );
                    Intent intent = new Intent(getActivity(), RedaianzxActivity.class);
                    intent.putExtra("name",moreURL);
                    startActivity(intent);
                }
            });
            two_rv.setAdapter(recycleViewAdapter);
        }
    }

    @Override
    public void onFailed(Exception e) {

    }
}
