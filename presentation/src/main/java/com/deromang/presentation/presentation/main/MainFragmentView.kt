package com.deromang.presentation.presentation.main

import com.deromang.domain.data.ResponseModel
import com.deromang.presentation.presentation.base.BaseView

interface MainFragmentView : BaseView {
    fun onShowLeaguesReady(list: ResponseModel?)
    fun showError()
}