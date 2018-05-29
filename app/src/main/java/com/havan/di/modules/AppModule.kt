package com.havan.di.modules

import android.app.Application
import android.content.Context
import com.havan.application.data.AppDataManager
import com.havan.application.data.DataManager
import com.havan.application.prefs.AppPreferencesHelper
import com.havan.application.prefs.PreferencesHelper
import com.havan.constants.AppConstants
import com.havan.di.scope.AppContext
import com.havan.di.scope.DatabaseInfo
import com.havan.di.scope.PreferenceInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val mApplication: Application) {

    @Provides
    @AppContext
    internal fun provideContext(): Context {
        return mApplication
    }

    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @DatabaseInfo
    internal fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }


    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }
}
