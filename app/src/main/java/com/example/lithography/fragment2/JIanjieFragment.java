package com.example.lithography.fragment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lithography.R;
import com.example.lithography.activity.XiangqingActivity;
import com.example.lithography.adapter.ListMoveAdapter;
import com.example.lithography.bean.XiangqingBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

/**
 * Created by 柴晓凯 on 2018/1/3.
 */

public class JIanjieFragment extends Fragment {

    private TextView daoyan;
    private TextView zhuyan;
    private RecyclerView jianjie_rv;
    private ListMoveAdapter listMovieAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jianjiefragment,container,false);
        //注册EventBus
        EventBus.getDefault().register(this);
        daoyan =(TextView)view.findViewById(R.id.daoyan);
        zhuyan =(TextView)view.findViewById(R.id.zhuyan);
        jianjie_rv =(RecyclerView)view.findViewById(R.id.jianjie_rv);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 3);
        jianjie_rv.setLayoutManager(manager);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //接收
    @Subscribe
    public void onEventMainThread(Object busbean) {
        if (busbean != null) {
            XiangqingBean movieBean = (XiangqingBean) busbean;
            XiangqingBean.RetBean ret = movieBean.getRet();
                daoyan.setText("导演  ：  " + ret.getDirector());
                zhuyan.setText("主演  ：  " + ret.getActors());

                List<XiangqingBean.RetBean.ListBean> list = ret.getList();
                final List<XiangqingBean.RetBean.ListBean.ChildListBean> childList = list.get(0).getChildList();
               listMovieAdapter = new ListMoveAdapter(getActivity(), childList);
                jianjie_rv.setAdapter(listMovieAdapter);
                //点击详情页中的那三张图片再进行跳转到详情页
            listMovieAdapter.setRecycleOnClickListener(new ListMoveAdapter.OnClickitemListener() {
                @Override
                public void onItemclick(int postion) {
                    getActivity().finish();
                    Intent intent = new Intent(getActivity(), XiangqingActivity.class);
                    intent.putExtra("id",childList.get(postion).getDataId()+"");
                    startActivity(intent);
                }
            });
        }
    }


    //反注册EventBus
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

}
