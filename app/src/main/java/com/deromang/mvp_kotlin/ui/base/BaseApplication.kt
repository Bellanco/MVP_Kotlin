package com.deromang.mvp_kotlin.ui.base

import android.app.Application
import com.deromang.mvp_kotlin.dependencies.app.ApplicationComponent
import com.deromang.mvp_kotlin.dependencies.app.ApplicationModule
import com.deromang.mvp_kotlin.dependencies.app.DaggerApplicationComponent
import com.deromang.mvp_kotlin.dependencies.app.preferences.Preferences
import com.deromang.mvp_kotlin.dependencies.app.preferences.PreferencesImpl

class BaseApplication : Application() {

    private lateinit var appComponent: ApplicationComponent

    lateinit var preferences: Preferences

    override fun onCreate() {

        super.onCreate()

        getPreferences()

        initDagger()
    }

    private fun getPreferences() {
        preferences = PreferencesImpl(applicationContext)
    }

    private fun initDagger() {
        appComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule())
            .build()
    }

    fun getAppComponent(): ApplicationComponent {
        return appComponent
    }


}