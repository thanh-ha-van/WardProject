package com.havan.network

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


// Created by HaVan on 5/27/2018.

public class FirebaseAuthApi {

    var fbAuth = FirebaseAuth.getInstance()

    public fun getCurrentAuthUser(): FirebaseUser? {

        return fbAuth.currentUser
    }

}