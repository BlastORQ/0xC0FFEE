package com.a0xcooffee.studentshelper;


public class News {

    String title = "", text = "", img_url = "";

    public News(String title, String text, String img_url) {
        this.title = title;
        this.text = text;
        this.img_url = img_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

}
