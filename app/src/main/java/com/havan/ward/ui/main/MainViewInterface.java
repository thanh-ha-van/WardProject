package com.havan.ward.ui.main;

import com.havan.ward.models.MovieResponse;


public interface MainViewInterface {

    void showToast(String s);

    void showProgressBar();

    void hideProgressBar();

    void displayMovies(MovieResponse movieResponse);

    void displayError(String s);
}
