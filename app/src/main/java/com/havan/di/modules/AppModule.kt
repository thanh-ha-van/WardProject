package com.havan.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


// Created by HaVan on 5/27/2018.

@Module
class AppModule(private val mApplication: Application) {

    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return mApplication
    }
}
