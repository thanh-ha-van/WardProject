package com.havan.activities.account.info

import com.havan.activities.base.view.BaseView
import com.havan.modules.ContextModule
import com.havan.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


// Created by HaVan on 5/27/2018.

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(postPresenter: AccountInfoPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}