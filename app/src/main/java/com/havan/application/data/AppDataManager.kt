package com.havan.application.data


import com.havan.application.prefs.PreferencesHelper

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager @Inject
constructor(private val mPreferencesHelper: PreferencesHelper) : DataManager {

    override var currentUserId: Long?
        get() = mPreferencesHelper.currentUserId
        set(userId) {
            mPreferencesHelper.currentUserId = userId
        }

    override var currentUserName: String
        get() = mPreferencesHelper.currentUserName
        set(userName) {
            mPreferencesHelper.currentUserName = userName
        }

    override var currentUserEmail: String
        get() = mPreferencesHelper.currentUserEmail
        set(email) {
            mPreferencesHelper.currentUserEmail = email
        }

    override var currentUserProfilePicUrl: String
        get() = mPreferencesHelper.currentUserProfilePicUrl
        set(profilePicUrl) {
            mPreferencesHelper.currentUserProfilePicUrl = profilePicUrl
        }

    override fun updateUserInfo(
            userId: Long?,
            userName: String,
            email: String,
            profilePicPath: String) {

        currentUserId = userId
        currentUserName = userName
        currentUserEmail = email
        currentUserProfilePicUrl = profilePicPath

    }

}
