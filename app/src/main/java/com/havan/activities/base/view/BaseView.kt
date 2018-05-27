package com.havan.activities.base.view

import android.content.Context


// Created by HaVan on 5/26/2018.


interface BaseView {

    fun showProgressDialog()

    fun onBackActionClicked()

    /**
     * Returns the context in which the application is running.
     * @return the context in which the application is running
     */
    fun getContext(): Context
}