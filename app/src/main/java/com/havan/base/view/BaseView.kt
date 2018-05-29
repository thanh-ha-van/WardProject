package com.havan.base.view

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun onError(message: String)

    fun showMessage(message: String)

    fun hideKeyboard()
}