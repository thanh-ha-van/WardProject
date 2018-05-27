package com.havan.activities.account.info

import com.havan.activities.base.presenter.BasePresenter
import com.havan.hereever.R
import com.havan.network.AccountApi
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


// Created by HaVan on 5/27/2018.

class AccountInfoPresenter(accountInfoView: AccountInfoView) : BasePresenter<AccountInfoView>(accountInfoView) {

    @Inject
    lateinit var postApi: AccountApi

    private var subscription: Disposable? = null

    override fun onViewCreated() {
        loadPosts()
    }

    /**
     * Loads the posts from the API and presents them in the view when retrieved, or showss error if
     * any.
     */
    fun loadPosts() {
        view.showLoading()
        subscription = postApi
                .account()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate { view.hideLoading() }
                .subscribe(
                        { postList -> view.updatePosts(postList) },
                        { view.showError(R.string.unknown_error) }
                )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}