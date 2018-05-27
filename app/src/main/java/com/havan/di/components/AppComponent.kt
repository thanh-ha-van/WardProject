package com.havan.di.components

import com.havan.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton


// Created by HaVan on 5/27/2018.

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent