package com.havan.di.scopes

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope


// Created by HaVan on 5/27/2018.

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerView
