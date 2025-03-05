package com.megha.myfoodapp.models;

public class FeaturedModel {
    int img;
    String name;
    String desc;

    public FeaturedModel(int img, String name, String desc) {
        this.img = img;
        this.name = name;
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
