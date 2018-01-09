package com.example.lithography.persenter;
import com.example.lithography.adapter.PinglunBean;
import com.example.lithography.bean.Dabean;
import com.example.lithography.bean.ReDianBean;
import com.example.lithography.bean.TanBean;
import com.example.lithography.bean.XiangqingBean;
import com.example.lithography.iview.Iview;
import com.example.lithography.model.Imodel;
import com.example.lithography.model.NewsModel;

import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by 柴晓凯 on 2018/1/2.
 */

public class NewsPresenter implements BasePresenter {

    private Iview iv;
    private DisposableSubscriber subscriber;
    public  void attacView(Iview iv){
        this.iv=iv;
    }

    public void detachView(){
        if(subscriber!=null){
            if(!subscriber.isDisposed()){
                subscriber.dispose();
            }
        }
    }

    public void getNews(Flowable<Dabean> news,final String tag){
        news.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Dabean>() {
                    @Override
                    public void onNext(Dabean dabean) {
                        if (dabean!=null){
                            iv.onSuccess(dabean,tag);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void getTan(Flowable<TanBean> news, final String tag) {
        news.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<TanBean>() {
                    @Override
                    public void onNext(TanBean dabean) {
                        if (dabean != null) {
                            iv.onSuccess(dabean, tag);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getXiangq(Flowable<XiangqingBean> news, final String tag) {
        news.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<XiangqingBean>() {
                    @Override
                    public void onNext(XiangqingBean dabean) {
                        if (dabean != null) {
                            iv.onSuccess(dabean, tag);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getPingl(Flowable<PinglunBean> news, final String tag) {
        news.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<PinglunBean>() {
                    @Override
                    public void onNext(PinglunBean dabean) {
                        if (dabean != null) {
                            iv.onSuccess(dabean, tag);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public void getRe(Flowable<ReDianBean> news, final String tag) {
        news.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<ReDianBean>() {
                    @Override
                    public void onNext(ReDianBean dabean) {
                        if (dabean != null) {
                            iv.onSuccess(dabean, tag);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void getData(Map<String, String> map, String tag) {
        Imodel model=new NewsModel(this);//多态  this是当前的p层、
        model.getData(map,tag);
    }
}
