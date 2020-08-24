package com.example.searchbooks.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.searchbooks.Model.Book;
import com.example.searchbooks.Model.BookDeserializador;
import com.example.searchbooks.Model.ConstantesApi;
import com.example.searchbooks.Model.EndsPointsApi;
import com.example.searchbooks.R;
import com.example.searchbooks.View.IViewDetailsBookActivity;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PresenterDetailsBookActivity implements IPresenterDetailsBookActivity{

    private Context context;
    private IViewDetailsBookActivity iViewDetailsBookActivity;

    public PresenterDetailsBookActivity(Context context, IViewDetailsBookActivity iViewDetailsBookActivity){
        this.context = context;
        this.iViewDetailsBookActivity = iViewDetailsBookActivity;
    }

    @Override
    public void getDetailsBook(String idBook) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Book.class, new BookDeserializador());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesApi.URL_WITH_VERSION)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .build();
        EndsPointsApi request = retrofit.create(EndsPointsApi.class);
        Call<Book> response = request.getDetailsBook(idBook);
        response.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
                Book detailsBook = response.body();
                String descripcion = context.getString(R.string.desc_book) +  detailsBook.getDescription();
                String authors = context.getString(R.string.authors_book) +  detailsBook.getAuthors();
                String year = context.getString(R.string.year_book) + detailsBook.getYear();
                String pages = context.getString(R.string.pages_book) + detailsBook.getPages();
                String price = context.getString(R.string.item_price) + detailsBook.getPrice();
                String rating = context.getString(R.string.book_rating) + detailsBook.getRating();
                iViewDetailsBookActivity.getInformationBook(detailsBook.getId(), detailsBook.getTitle(), detailsBook.getSubTitle(),
                        detailsBook.getImage(), authors, year, pages, price, descripcion, rating);
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(context, context.getString(R.string.error_request_details_book), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
