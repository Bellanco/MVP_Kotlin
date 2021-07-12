package com.deromang.presentation.presentation.main

import com.deromang.presentation.presentation.base.BasePresenter

interface MainFragmentPresenter : BasePresenter<MainFragmentView> {
    fun getAPIService()
    fun showModel()
    fun searchModel(text: String)
}