package com.havan.activities.profile.view

import android.os.Bundle
import android.widget.Toast
import com.havan.activities.profile.presenter.ProfilePresenter
import com.havan.base.view.BaseActivity
import com.havan.di.components.ActivityComponent
import com.havan.di.components.AppComponent
import com.havan.di.components.DaggerActivityComponent
import com.havan.di.modules.ActivityModule
import javax.inject.Inject


// Created by HaVan on 5/27/2018.

class ProfileActivity : BaseActivity(),
        ProfileView {

    @Inject
    lateinit var mPresenter: ProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.loadProfile("thanh")
    }

    override fun setUp() {

    }

    override fun showProfile(profile: String) {

        Toast.makeText(this, profile, Toast.LENGTH_LONG).show()
    }
}
