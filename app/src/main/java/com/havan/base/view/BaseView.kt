package com.havan.base.view

import android.content.Context

interface BaseView {

    fun attachView(): Int

    fun updateUI()

    fun setUpActionBar()

    fun getContext(): Context
}