package com.example.lithography.model;

import com.example.lithography.adapter.PinglunBean;
import com.example.lithography.bean.Dabean;
import com.example.lithography.bean.ReDianBean;
import com.example.lithography.bean.TanBean;
import com.example.lithography.bean.XiangqingBean;
import com.example.lithography.persenter.NewsPresenter;
import com.example.lithography.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by 柴晓凯 on 2018/1/2.
 */

public class NewsModel implements Imodel{

    private NewsPresenter presenter;

    public NewsModel(NewsPresenter presenter){
        this.presenter=presenter;
    }
    @Override
    public void getData(Map<String, String> map,String tag) {
        if (tag.equals("轮播")) {
            Flowable<Dabean> news = RetrofitUtils.getInstance().getApiService().getNews(map);
            presenter.getNews(news,tag);
        }else if(tag.equals("探探")){
            Flowable<TanBean> news = RetrofitUtils.getInstance().getApiService().getTan(map);
            presenter.getTan(news,tag);
        }else if(tag.equals("详情")){
            Flowable<XiangqingBean> news = RetrofitUtils.getInstance().getApiService().getXiangq(map);
            presenter.getXiangq(news,tag);
        }else if(tag.equals("评论")){
            Flowable<PinglunBean> news = RetrofitUtils.getInstance().getApiService().getPingl(map);
            presenter.getPingl(news,tag);
        }else if(tag.equals("热点")){
            Flowable<ReDianBean> news = RetrofitUtils.getInstance().getApiService().getRe(map);
            presenter.getRe(news,tag);
        }
    }
}
