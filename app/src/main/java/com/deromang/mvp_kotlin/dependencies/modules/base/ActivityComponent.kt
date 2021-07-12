package com.deromang.mvp_kotlin.dependencies.modules.base

import com.deromang.mvp_kotlin.dependencies.app.ApplicationComponent
import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.ActivityScope
import com.deromang.mvp_kotlin.dependencies.modules.presentation.activity.MainComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.second.SecondFragmentComponent
import com.deromang.presentation.navigation.Navigator
import dagger.Component

@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class]
)
@ActivityScope
interface ActivityComponent {

    fun providesNavigator(): Navigator

    fun mainComponent(): MainComponent.Builder

    fun mainFragmentComponent(): MainFragmentComponent.Builder

    fun secondFragmentComponent(): SecondFragmentComponent.Builder

}