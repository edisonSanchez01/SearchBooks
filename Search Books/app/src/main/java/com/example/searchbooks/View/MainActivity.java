package com.example.searchbooks.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.searchbooks.Model.BookListAdapter;
import com.example.searchbooks.Model.ConstantesApi;
import com.example.searchbooks.Model.ItemBookList;
import com.example.searchbooks.Presenter.PresenterMainActivity;
import com.example.searchbooks.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IViewMainActivity, BookListAdapter.OnItemClickListener {

    private TextInputEditText editText;
    private RecyclerView recyclerView;
    private Button btnSearch;
    private TextView titleResults;
    private PresenterMainActivity presenter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.searcher);
        recyclerView = findViewById(R.id.recyclerView);
        btnSearch = findViewById(R.id.btnSearch);
        titleResults = findViewById(R.id.title_results);
        toolbar = findViewById(R.id.action_bar);
        presenter = new PresenterMainActivity(this, this);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateText(editText.getText().toString(), editText);
            }
        });
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public void configAdapterRecyclerView(ArrayList<ItemBookList> list) {
        recyclerView.setHasFixedSize(true);
        titleResults.setVisibility(View.VISIBLE);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        BookListAdapter adapter = new BookListAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(String idBook) {
        Intent detailsBook = new Intent(this, DetailsBookActivity.class);
        detailsBook.putExtra(ConstantesApi.ID_BOOK, idBook);
        startActivity(detailsBook);
    }


}