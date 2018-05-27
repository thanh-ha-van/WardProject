package com.havan.activities.profile.presenter

import com.havan.activities.base.presenter.BasePresenter
import com.havan.activities.profile.view.ProfileView


// Created by HaVan on 5/27/2018.

interface ProfilePresenter : BasePresenter<ProfileView> {
    fun loadProfile(name: String)
}