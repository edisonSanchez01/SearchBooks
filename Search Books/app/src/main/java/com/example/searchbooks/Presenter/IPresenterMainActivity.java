package com.example.searchbooks.Presenter;

import com.google.android.material.textfield.TextInputEditText;

public interface IPresenterMainActivity {

        void consumeApi(String query);
        void validateText(String text, TextInputEditText editText);

}
