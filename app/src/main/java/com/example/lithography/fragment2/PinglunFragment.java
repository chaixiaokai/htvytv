package com.example.lithography.fragment2;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.lithography.R;
import com.example.lithography.adapter.PinglunAdapter;
import com.example.lithography.adapter.PinglunBean;
import com.example.lithography.iview.Iview;
import com.example.lithography.persenter.NewsPresenter;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 柴晓凯 on 2018/1/3.
 */

@SuppressLint("ValidFragment")
public class PinglunFragment extends Fragment implements Iview{
    private String uid;
    private RecyclerView pinglun_rv;
    private NewsPresenter presenter;

    public PinglunFragment(String uid) {
        this.uid = uid;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pinglunfragment,container,false);
        pinglun_rv =(RecyclerView)view.findViewById(R.id.pinglun_rv);
        if (uid != null) {
            presenter = new NewsPresenter();
            presenter.attacView(this);
            HashMap<String, String> map = new HashMap<>();
            map.put("mediaId", uid);
            presenter.getData(map, "评论");
        }
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        pinglun_rv.setLayoutManager(manager);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSuccess(Object o, String tag) {
        if (tag.equals("评论")) {
            PinglunBean pingLunBean = (PinglunBean) o;
            List<PinglunBean.RetBean.ListBean> list = pingLunBean.getRet().getList();
            PinglunAdapter pingLunAdapter = new PinglunAdapter(list, getActivity());
            pinglun_rv.setAdapter(pingLunAdapter);
        }
    }

    @Override
    public void onFailed(Exception e) {

    }
}
