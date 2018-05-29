package com.havan.di.components


import com.havan.activities.profile.view.ProfileActivity
import com.havan.di.modules.ActivityModule
import com.havan.di.scope.PerActivity
import dagger.Component

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(profileActivity: ProfileActivity)
}
