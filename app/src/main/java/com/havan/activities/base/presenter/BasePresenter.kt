package com.havan.activities.base.presenter

import com.havan.activities.account.info.AccountInfoPresenter
import com.havan.activities.account.info.PresenterInjector
import com.havan.activities.base.view.BaseView
import com.havan.modules.ContextModule
import com.havan.modules.NetworkModule


// Created by HaVan on 5/26/2018.

abstract class BasePresenter<out V : BaseView>(protected val view: V) {


    private val injector: PresenterInjector = DaggerAccountInfoInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    // ...

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is AccountInfoPresenter -> injector.inject(this)
        }
    }

    init {
        inject()
    }

    /**
     * This method may be called when the presenter view is created
     */
    open fun onViewCreated() {}

    /**
     * This method may be called when the presenter view is destroyed
     */
    open fun onViewDestroyed() {}

    /**
     * Injects the required dependencies
     */

}