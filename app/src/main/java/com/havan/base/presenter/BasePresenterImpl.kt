package com.havan.base.presenter

import com.havan.base.view.BaseView

// Created by HaVan on 5/26/2018.

open class BasePresenterImpl<in V : BaseView> : BasePresenter<V> {

    private var mView: V? = null


    override fun attachView(view: V) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }
}