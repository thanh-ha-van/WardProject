package com.havan

import android.app.Application
import com.havan.application.data.DataManager
import com.havan.di.components.AppComponent
import com.havan.di.modules.AppModule
import javax.inject.Inject


// Created by HaVan on 5/28/2018.


class MyApp : Application() {

    @Inject
    internal var mDataManager: DataManager? = null

    var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .applicationModule(AppModule(this)).build()

        component!!.inject(this)

    }
}
