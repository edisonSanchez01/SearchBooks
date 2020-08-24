package com.example.searchbooks.Model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ItemBookDeserializador implements JsonDeserializer<BooksSearchResponse> {

    @Override
    public BooksSearchResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        BooksSearchResponse itemBookResponse = gson.fromJson(json, BooksSearchResponse.class);
        ArrayList<ItemBookList> bookList = new ArrayList<>();
        JsonArray jsonArray = json.getAsJsonObject().getAsJsonArray(ConstantesApi.NAME_LIBROS);
        for(int i = 0; i < jsonArray.size(); i++){
            JsonObject currentBook = jsonArray.get(i).getAsJsonObject();
            String id = currentBook.get(ConstantesApi.NAME_ID_BOOK).getAsString();
            String title = currentBook.get(ConstantesApi.NAME_TITLE_BOOK).getAsString();
            String subTitle = currentBook.get(ConstantesApi.NAME_SUBTITLE_BOOK).getAsString();
            String image = currentBook.get(ConstantesApi.NAME_IMAGE_BOOK).getAsString();
            String price = currentBook.get(ConstantesApi.NAME_PRICE_BOOK).getAsString();
            ItemBookList book = new ItemBookList(id, image, title, subTitle, price);
            bookList.add(book);
        }
        itemBookResponse.setListBooks(bookList);
        return itemBookResponse;
    }
}
