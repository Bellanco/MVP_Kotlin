package com.deromang.mvp_kotlin.ui.activity

import androidx.viewpager.widget.ViewPager
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.dependencies.modules.presentation.activity.MainComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.activity.MainModule
import com.deromang.mvp_kotlin.ui.activity.adapter.SectionsPagerAdapter
import com.deromang.mvp_kotlin.ui.base.BaseActivity
import com.deromang.presentation.presentation.activity.MainPresenter
import com.deromang.presentation.presentation.activity.MainView
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private var mainComponent: MainComponent? = null

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initComponent() {
        mainComponent = getActivityComponent()
            ?.mainComponent()
            ?.mainModule(MainModule())
            ?.build()

        mainComponent?.inject(this)

        presenter.setView(this)

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }

}
