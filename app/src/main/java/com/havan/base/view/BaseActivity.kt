package com.havan.base.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.havan.base.presenter.BasePresenter
import com.havan.customviews.MyDialog


// Created by HaVan on 5/26/2018.

abstract class BaseMvpActivity<in V : BaseView, T : BasePresenter<V>>
    : AppCompatActivity(), BaseView , MyDialog.ClickListener{


    override fun getContext(): Context = this

    protected abstract var mPresenter: T

    private var mDialog: MyDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)
        mDialog = MyDialog(this, this)
    }

    override fun onOKClicked() {

    }

    override fun onCancelClicked() {

    }

    override fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}