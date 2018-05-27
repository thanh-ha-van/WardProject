package com.havan.activities.profile.view

import android.os.Bundle
import com.havan.R
import com.havan.activities.base.view.BaseActivity
import com.havan.activities.profile.presenter.ProfilePresenter
import com.havan.activities.profile.presenter.ProfilePresenterImpl
import com.havan.objects.Profile


// Created by HaVan on 5/27/2018.

class ProfileActivity : BaseActivity<ProfileView,
        ProfilePresenter>(),
        ProfileView {

    override var mPresenter: ProfilePresenter = ProfilePresenterImpl()

    override fun showProfile(profile: Profile) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mPresenter.loadProfile("thanh")
    }


}