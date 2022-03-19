package com.example.mvvmarchitecture_demo_project.models;

public class nicePlace {

    String title;
    String imageUrl;

    public nicePlace() {
    }

    public nicePlace(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
