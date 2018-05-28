package com.havan.activities.profile.view

import android.os.Bundle
import com.havan.activities.profile.presenter.ProfilePresenter
import com.havan.activities.profile.presenter.ProfilePresenterImpl
import com.havan.base.view.BaseActivity
import com.havan.hereever.R
import com.havan.objects.Profile


// Created by HaVan on 5/27/2018.

class ProfileActivity : BaseActivity<ProfileView, ProfilePresenter>(),
        ProfileView {

    override var mPresenter: ProfilePresenter = ProfilePresenterImpl()

    override fun showProfile(profile: Profile) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.loadProfile("")
    }


    override fun attachView(): Int {
        return R.layout.activity_splash;
    }

    override fun updateUI() {

    }

    override fun setUpActionBar() {

    }
}
