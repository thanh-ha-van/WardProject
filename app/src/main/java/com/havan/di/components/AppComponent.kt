package com.havan.di.components

import com.havan.activities.profile.presenter.ProfilePresenter
import com.havan.activities.profile.view.ProfileActivity
import com.havan.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton


// Created by HaVan on 5/27/2018.

@Component(modules = [AppModule::class])
@Singleton
public interface AppComponent {

    fun inject(mProfilePresenter: ProfilePresenter)
    fun inject(mProfileActivity: ProfileActivity)
}