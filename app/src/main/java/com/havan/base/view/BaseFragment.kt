package com.havan.base.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import butterknife.Unbinder
import com.havan.di.components.ActivityComponent


// Created by HaVan on 5/29/2018.

abstract class BaseFragment : Fragment(), BaseView {

    var baseActivity: BaseActivity? = null
        private set
    private var mUnBinder: Unbinder? = null

    val activityComponent: ActivityComponent?
        get() {
            return if (baseActivity != null) {
                baseActivity!!.activityComponent
            } else null
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp(view)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.baseActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun showLoading() {

        //TODO show waiting view. implement later
        if (baseActivity != null) {
            baseActivity!!.showLoading()
        }
    }

    override fun hideLoading() {
        //TODO hide waiting view. implement later
        if (baseActivity != null) {
            baseActivity!!.hideLoading()
        }
    }

    override fun onError(message: String) {
        if (baseActivity != null) {
            baseActivity!!.onError(message)
        }
    }


    override fun showMessage(message: String) {
        if (baseActivity != null) {
            baseActivity!!.showMessage(message)
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun hideKeyboard() {
        if (baseActivity != null) {
            baseActivity!!.hideKeyboard()
        }
    }

    protected abstract fun setUp(view: View)

    override fun onDestroy() {
        if (mUnBinder != null) {
            mUnBinder!!.unbind()
        }
        super.onDestroy()
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}
