package com.example.searchbooks.Model;

public class ItemBookList {

    private String id;
    private String image;
    private String title;
    private String subTitle;
    private String price;

    public ItemBookList(String id, String image, String title, String subTitle, String price){
        this.id = id;
        this.image = image;
        this.title = title;
        this.subTitle = subTitle;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
