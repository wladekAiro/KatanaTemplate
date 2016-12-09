package com.example.wladek.katanatemplate.models;

public class Data {
    private String desc;
    private int image1;
    private int image2;
    private String title1;
    private String title2;

    public Data(String title1, String desc, int image1) {
        this.title1 = title1;
        this.desc = desc;
        this.image1 = image1;
    }

    public Data(String title1, int image1, int image2) {
        this.title1 = title1;
        this.image1 = image1;
        this.image2 = image2;
    }

    public String getTitle1() {
        return this.title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return this.title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImage1() {
        return this.image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public int getImage2() {
        return this.image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }
}
