package com.example.lithography.iview;

/**
 * Created by 柴晓凯 on 2018/1/2.
 */

public interface Iview {
    void onSuccess(Object o,String tag);
    void onFailed(Exception e);
}
