package com.havan.activities.profile.view

import com.havan.activities.base.view.BaseView
import com.havan.objects.Profile


// Created by HaVan on 5/27/2018.

interface ProfileView : BaseView {

    fun showProfile(profile: Profile)

}