package com.example.searchbooks.Model;

import java.util.ArrayList;

public class BooksSearchResponse {

    private ArrayList<ItemBookList> listBooks;

    public ArrayList<ItemBookList> getListBooks() {
        return listBooks;
    }

    public void setListBooks(ArrayList<ItemBookList> listBooks) {
        this.listBooks = listBooks;
    }
}
