package com.havan.ward;

import android.app.Application;

import com.havan.ward.di.components.ApplicationComponent;
import com.havan.ward.di.components.DaggerApplicationComponent;
import com.havan.ward.di.modules.ApplicationModule;


public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;

    public MyApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
