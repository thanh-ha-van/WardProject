package com.havan.base.presenter

import com.havan.application.data.DataManager
import com.havan.base.view.BaseView
import javax.inject.Inject

// Created by HaVan on 5/26/2018.

open class BasePresenterImpl<in V : BaseView> @Inject constructor(dataManager: DataManager) : BasePresenter<V> {

    private val TAG = "BasePresenter"

    private var mDataManager: DataManager? = null
    private var mBaseView: V? = null


    init {
        this.mDataManager = dataManager
    }

    override fun onAttach(mvpView: V) {
        mBaseView = mvpView
    }


//    fun getMvpView(): V {
//        return mBaseView as V
//    }
//

    override fun onDetach() {
        mBaseView = null
    }
}