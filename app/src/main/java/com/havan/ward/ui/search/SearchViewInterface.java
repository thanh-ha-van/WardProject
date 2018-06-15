package com.havan.ward.ui.search;

import com.havan.ward.models.MovieResponse;


public interface SearchViewInterface {

    void showToast(String str);

    void displayResult(MovieResponse movieResponse);

    void displayError(String s);

    void showProgressBar();

    void hideProgressBar();
}
