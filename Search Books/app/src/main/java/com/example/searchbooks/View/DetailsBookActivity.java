package com.example.searchbooks.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.searchbooks.Model.ConstantesApi;
import com.example.searchbooks.Presenter.PresenterDetailsBookActivity;
import com.example.searchbooks.R;
import com.squareup.picasso.Picasso;

public class DetailsBookActivity extends AppCompatActivity implements IViewDetailsBookActivity {

    private TextView title;
    private TextView subTitle;
    private ImageView image;
    private TextView descrption;
    private TextView authors;
    private TextView pages;
    private TextView year;
    private TextView price;
    private TextView raiting;
    private Toolbar toolbar;
    private TextView titleDetails;
    private PresenterDetailsBookActivity presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_book);
        title = findViewById(R.id.title);
        subTitle = findViewById(R.id.subTitle);
        image = findViewById(R.id.image);
        descrption = findViewById(R.id.description);
        authors = findViewById(R.id.authors);
        pages = findViewById(R.id.pages);
        year = findViewById(R.id.year);
        price = findViewById(R.id.price);
        raiting = findViewById(R.id.rating);
        toolbar = findViewById(R.id.action_bar);
        titleDetails = toolbar.findViewById(R.id.text_action_bar);
        presenter = new PresenterDetailsBookActivity(this, this);
        titleDetails.setText(R.string.title_details);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!= null){

            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        if(getIntent().getExtras()!= null){
            presenter.getDetailsBook(getIntent().getStringExtra(ConstantesApi.ID_BOOK));
        }

    }

    @Override
    public void getInformationBook(String id, String title, String subTitle, String urlImage, String authors, String year, String pages,
                                   String price, String descrption, String raiting) {

        this.title.setText(title);
        this.subTitle.setText(subTitle);
        Picasso.get().load(urlImage).placeholder(R.mipmap.ic_launcher).into(image);
        this.descrption.setText(descrption);
        this.authors.setText(authors);
        this.pages.setText(pages);
        this.year.setText(year);
        this.price.setText(price);
        this.raiting.setText(raiting);

    }
}