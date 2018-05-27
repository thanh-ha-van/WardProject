package com.havan.di.modules

import android.app.Application
import android.content.Context
import com.havan.base.view.BaseView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


// Created by HaVan on 5/27/2018.

@Module
class AppModule(var application: Application) {

    lateinit var applicationInst: Application

    init {
        applicationInst = application
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return applicationInst
    }

    @Provides
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    @Provides
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}