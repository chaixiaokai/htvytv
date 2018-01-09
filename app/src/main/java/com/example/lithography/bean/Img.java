package com.example.lithography.bean;

/**
 * Created by 柴晓凯 on 2018/1/2.
 */

public class Img {
    private String title;
    private String img;

    public Img(String title, String img) {
        this.title = title;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
