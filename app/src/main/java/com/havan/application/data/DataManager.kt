package com.havan.application.data


import com.havan.application.prefs.PreferencesHelper

interface DataManager : PreferencesHelper {

    fun updateUserInfo(
            userId: Long?,
            userName: String,
            email: String,
            profilePicPath: String)
}
