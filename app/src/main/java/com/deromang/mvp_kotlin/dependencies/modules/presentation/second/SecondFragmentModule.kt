package com.deromang.mvp_kotlin.dependencies.modules.presentation.second

import com.deromang.mvp_kotlin.dependencies.modules.base.scopes.PresentationScope
import com.deromang.presentation.presentation.main.MainFragmentPresenter
import com.deromang.presentation.presentation.main.MainFragmentPresenterImpl
import com.deromang.presentation.presentation.second.SecondFragmentPresenter
import com.deromang.presentation.presentation.second.SecondFragmentPresenterImpl
import dagger.Module
import dagger.Provides

@Module
class SecondFragmentModule {

    @Provides
    @PresentationScope
    fun providesMainFragmentPresenter(mainFragmentPresenter: SecondFragmentPresenterImpl): SecondFragmentPresenter {
        return mainFragmentPresenter
    }
}