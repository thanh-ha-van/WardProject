package com.havan.activities.profile.presenter

import com.havan.activities.profile.view.ProfileView
import com.havan.application.data.DataManager
import com.havan.base.presenter.BasePresenterImpl
import javax.inject.Inject


// Created by HaVan on 5/27/2018.

class ProfilePresenterImpl @Inject constructor(dataManager: DataManager) : BasePresenterImpl<ProfileView>(dataManager),
        ProfilePresenter {


    override fun loadProfile(name: String) {

    }
}