package com.example.searchbooks.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EndsPointsApi {

    @GET(ConstantesApi.SEARCH_BOOKS)
     Call<BooksSearchResponse> searchBooks(@Path(ConstantesApi.PATH_QUERY) String query);

    @GET(ConstantesApi.GET_DEATILS_BOOK)
    Call<Book> getDetailsBook(@Path(ConstantesApi.PATH_ISBN13) String isbn13);

}
