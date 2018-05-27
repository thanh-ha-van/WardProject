package com.havan.base.presenter

import com.havan.base.view.BaseView


// Created by HaVan on 5/26/2018.

interface BasePresenter<in V : BaseView> {

    fun attachView(view: V)

    fun detachView()
}