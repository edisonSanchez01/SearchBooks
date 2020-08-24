package com.example.searchbooks.Model;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class BookDeserializador implements JsonDeserializer<Book> {

    @Override
    public Book deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        Book bookResponse = gson.fromJson(json, Book.class);
        JsonObject detailsBook = json.getAsJsonObject();
        bookResponse.setId(detailsBook.get(ConstantesApi.NAME_ID_BOOK).getAsString());
        bookResponse.setTitle(detailsBook.get(ConstantesApi.NAME_TITLE_BOOK).getAsString());
        bookResponse.setSubTitle(detailsBook.get(ConstantesApi.NAME_SUBTITLE_BOOK).getAsString());
        bookResponse.setImage(detailsBook.get(ConstantesApi.NAME_IMAGE_BOOK).getAsString());
        bookResponse.setAuthors(detailsBook.get(ConstantesApi.AUTHORS_BOOK).getAsString());
        bookResponse.setYear(detailsBook.get(ConstantesApi.YEAR_BOOK).getAsString());
        bookResponse.setPages(detailsBook.get(ConstantesApi.PAGES_BOOK).getAsString());
        bookResponse.setPrice(detailsBook.get(ConstantesApi.NAME_PRICE_BOOK).getAsString());
        bookResponse.setDescription(detailsBook.get(ConstantesApi.DESCRIPCION_BOOK).getAsString());
        bookResponse.setRating(detailsBook.get(ConstantesApi.RATING_BOOK).getAsString());
        return bookResponse;
    }

}
