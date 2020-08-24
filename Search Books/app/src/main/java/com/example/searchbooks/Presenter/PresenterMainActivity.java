package com.example.searchbooks.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.searchbooks.Model.ItemBookDeserializador;
import com.example.searchbooks.Model.BooksSearchResponse;
import com.example.searchbooks.Model.ConstantesApi;
import com.example.searchbooks.Model.EndsPointsApi;
import com.example.searchbooks.R;
import com.example.searchbooks.View.IViewMainActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PresenterMainActivity implements IPresenterMainActivity{

    private Context context;
    private IViewMainActivity iViewMainActivity;

    public PresenterMainActivity(Context context, IViewMainActivity iViewMainActivity){
        this.context = context;
        this.iViewMainActivity = iViewMainActivity;
    }

    @Override
    public void consumeApi(String query) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BooksSearchResponse.class, new ItemBookDeserializador());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesApi.URL_WITH_VERSION)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .build();
        EndsPointsApi request = retrofit.create(EndsPointsApi.class);
        Call<BooksSearchResponse> response = request.searchBooks(query);
        response.enqueue(new Callback<BooksSearchResponse>() {
            @Override
            public void onResponse(Call<BooksSearchResponse> call, Response<BooksSearchResponse> response) {
                BooksSearchResponse responseBody = response.body();
                iViewMainActivity.configAdapterRecyclerView(responseBody.getListBooks());
            }

            @Override
            public void onFailure(Call<BooksSearchResponse> call, Throwable t) {
                Toast.makeText(context, context.getString(R.string.error_request),Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void validateText(String text, TextInputEditText editText) {
        if(text.isEmpty()){
            editText.setError(context.getString(R.string.error_empty_text));
        }else if(text.length() < 4){
            editText.setError(context.getString(R.string.error_invalid_text));
        }else{
            consumeApi(text);
        }
    }
}
