package com.havan.application.prefs

import android.content.Context
import android.content.SharedPreferences

import com.havan.constants.AppConstants
import com.havan.di.scope.ApplicationContext
import com.havan.di.scope.PreferenceInfo

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppPreferencesHelper @Inject
constructor(@ApplicationContext context: Context,
            @PreferenceInfo prefFileName: String) : PreferencesHelper {

    companion object {
        const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
        const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
        const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
        const val PREF_KEY_CURRENT_USER_PROFILE_PIC_URL = "PREF_KEY_CURRENT_USER_PROFILE_PIC_URL"
    }

    private val mPrefs: SharedPreferences

    init {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)
    }

    override var currentUserId: Long?
        get() {
            val userId = mPrefs.getLong(PREF_KEY_CURRENT_USER_ID, AppConstants.NULL_INDEX)
            return if (userId == AppConstants.NULL_INDEX) null else userId
        }
        set(userId) {
            val id = userId ?: AppConstants.NULL_INDEX
            mPrefs.edit().putLong(PREF_KEY_CURRENT_USER_ID, id).apply()
        }

    override var currentUserName: String
        get() = mPrefs.getString(PREF_KEY_CURRENT_USER_NAME, null)
        set(userName) = mPrefs.edit().putString(PREF_KEY_CURRENT_USER_NAME, userName).apply()

    override var currentUserEmail: String
        get() = mPrefs.getString(PREF_KEY_CURRENT_USER_EMAIL, null)
        set(email) = mPrefs.edit().putString(PREF_KEY_CURRENT_USER_EMAIL, email).apply()

    override var currentUserProfilePicUrl: String
        get() = mPrefs.getString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, null)
        set(profilePicUrl) = mPrefs.edit().putString(PREF_KEY_CURRENT_USER_PROFILE_PIC_URL, profilePicUrl).apply()


}
