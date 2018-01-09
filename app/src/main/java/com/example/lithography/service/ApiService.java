package com.example.lithography.service;

import com.example.lithography.adapter.PinglunBean;
import com.example.lithography.bean.Dabean;
import com.example.lithography.bean.ReDianBean;
import com.example.lithography.bean.TanBean;
import com.example.lithography.bean.XiangqingBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by 柴晓凯 on 2018/1/2.
 */

public interface ApiService {
    //首页
    @GET("homePageApi/homePage.do")
    Flowable<Dabean> getNews(@QueryMap Map<String, String> map);

    //探探
    @GET("columns/getVideoList.do")
    Flowable<TanBean> getTan(@QueryMap Map<String, String> map);

    //详情
    @GET("videoDetailApi/videoDetail.do")
    Flowable<XiangqingBean> getXiangq(@QueryMap Map<String, String> map);

    //评论
    @GET("Commentary/getCommentList.do")
    Flowable<PinglunBean> getPingl(@QueryMap Map<String, String> map);

    //热点
    @GET("columns/getNewsList.do")
    Flowable<ReDianBean> getRe(@QueryMap Map<String, String> map);

}
