package com.example.searchbooks.Model;

public class Book {

    private String id;
    private String title;
    private String subTitle;
    private String image;
    private String authors;
    private String year;
    private String pages;
    private String price;
    private String description;
    private String rating;

    public Book(String id, String title, String subTitle, String image, String authors, String year, String pages, String price,
                String description, String rating){
            this.id          = id;
            this.title       =  title;
            this.subTitle    = subTitle;
            this.image       = image;
            this.authors     = authors;
            this.year        = year;
            this.pages       = pages;
            this.price       = price;
            this.description = description;
            this.rating     = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String raiting) {
        this.rating = raiting;
    }
}
