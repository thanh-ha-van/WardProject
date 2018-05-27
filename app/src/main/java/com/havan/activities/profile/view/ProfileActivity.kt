package com.havan.activities.profile.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.havan.base.view.BaseMvpActivity
import com.havan.activities.profile.presenter.ProfilePresenter
import com.havan.activities.profile.presenter.ProfilePresenterImpl
import com.havan.R
import com.havan.objects.Profile


// Created by HaVan on 5/27/2018.

class ProfileActivity : BaseMvpActivity<ProfileView,
        ProfilePresenter>(),
        ProfileView {

    override var mPresenter: ProfilePresenter = ProfilePresenterImpl()

    companion object {
        private const val NAME = "name"

        fun newIntent(context: Context, name: String): Intent =
                Intent(context, ProfileActivity::class.java).apply {
                    putExtra(NAME, name)
                }
    }

    override fun showProfile(profile: Profile) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        mPresenter.loadProfile(intent.getStringExtra(NAME))
    }


}