package com.havan.base.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.havan.base.presenter.BasePresenter


// Created by HaVan on 5/26/2018.

abstract class BaseActivity<in V : BaseView, T : BasePresenter<V>>
    : AppCompatActivity(), BaseView {

    override fun getContext(): Context = this
    protected abstract var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(attachView())
        setUpActionBar()
        updateUI()
        mPresenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

}