package com.havan.activities.base.view

import android.content.Context


// Created by HaVan on 5/26/2018.


interface BaseView {

    fun getContext(): Context

    fun showError(error: String?)

    fun showMessage(message: String)
}