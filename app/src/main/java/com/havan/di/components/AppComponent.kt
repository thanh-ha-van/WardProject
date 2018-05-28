package com.havan.di.components

import android.app.Application
import android.content.Context
import com.havan.MyApp
import com.havan.application.data.DataManager
import com.havan.di.modules.AppModule
import com.havan.di.scope.ApplicationContext
import dagger.Component
import javax.inject.Singleton


// Created by HaVan on 5/27/2018.


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    val dataManager: DataManager

    fun inject(app: MyApp)

    @ApplicationContext
    fun context(): Context

    fun application(): Application
}