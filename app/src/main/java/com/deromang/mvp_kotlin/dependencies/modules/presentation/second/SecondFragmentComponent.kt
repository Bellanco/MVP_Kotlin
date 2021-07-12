package com.deromang.mvp_kotlin.dependencies.modules.presentation.second

import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.PresentationScope
import com.deromang.mvp_kotlin.ui.main.SecondFragment
import com.deromang.presentation.presentation.second.SecondFragmentPresenter
import dagger.Subcomponent

@Subcomponent(modules = [SecondFragmentModule::class])
@PresentationScope
interface SecondFragmentComponent {

    fun inject(mainFragment: SecondFragment)

    fun providesMainFragmentPresenter(): SecondFragmentPresenter

    @Subcomponent.Builder
    interface Builder {

        fun mainFragmentModule(module: SecondFragmentModule): Builder

        fun build(): SecondFragmentComponent

    }

}