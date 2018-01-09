package com.example.lithography.utils;
import com.example.lithography.service.ApiService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 柴晓凯 on 2018/1/2.
 */

public class RetrofitUtils {
    private  static  volatile RetrofitUtils instance;
    private final ApiService apiService;

    private RetrofitUtils(){
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://api.svipmovie.com/front/")
                .client(new OkHttpClient.Builder().build())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static  RetrofitUtils getInstance(){
        if (instance==null){
            synchronized (RetrofitUtils.class){
                if (null==instance){
                    instance=new RetrofitUtils();
                }
            }
        }
        return  instance;
    }
    public ApiService getApiService(){
        return  apiService;    }
}
