package com.havan.network;

// Created by HaVan on 5/27/2018.

import com.havan.objects.Account;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface AccountApi {

    @GET("/posts")
    fun getAccount():Observable<Account>
}