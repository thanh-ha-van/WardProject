package com.havan.modules

import android.app.Application
import android.content.Context
import com.havan.activities.base.view.BaseView
import dagger.Module
import dagger.Provides

// Created by HaVan on 5/27/2018.

@Module
@Suppress("unused")
object ContextModule {

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getContext()
    }

    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}