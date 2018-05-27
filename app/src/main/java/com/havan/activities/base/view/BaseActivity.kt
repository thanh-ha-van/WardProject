package com.havan.activities.base.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.havan.activities.base.presenter.BasePresenter


// Created by HaVan on 5/26/2018.

abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }

    /**
     * Instantiates the presenter the Activity is based on.
     */
    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }
}