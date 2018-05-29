package com.havan.base.view

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.havan.di.components.ActivityComponent
import com.havan.di.components.AppComponent
import com.havan.di.components.DaggerActivityComponent
import com.havan.di.modules.ActivityModule


// Created by HaVan on 5/26/2018.

abstract class BaseActivity : AppCompatActivity(), BaseView, BaseFragment.Callback {


    var activityComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(ActivityModule(this))
                .appComponent(application as AppComponent)
                .build()

    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun showLoading() {
    }

    override fun hideLoading() {

    }

    override fun onError(message: String) {

    }

    override fun showMessage(message: String) {

    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    protected abstract fun setUp()
}
