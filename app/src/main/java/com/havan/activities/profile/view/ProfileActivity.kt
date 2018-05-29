package com.havan.activities.profile.view

import android.os.Bundle
import com.havan.base.view.BaseActivity
import com.havan.di.components.ActivityComponent
import com.havan.di.components.AppComponent
import com.havan.di.components.DaggerActivityComponent
import com.havan.di.modules.ActivityModule
import com.havan.objects.Profile


// Created by HaVan on 5/27/2018.

class ProfileActivity : BaseActivity(),
        ProfileView {

    private var mActivityComponent: ActivityComponent? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .appComponent(application as AppComponent)
                .build()

    }

    override fun setUp() {

    }

    override fun showProfile(profile: Profile) {

    }
}
