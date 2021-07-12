package com.deromang.presentation.presentation.main

import com.deromang.domain.data.ResponseModel
import com.deromang.presentation.presentation.base.BaseView

interface MainFragmentView : BaseView {
    fun onShowModelReady(list: ResponseModel?)
    fun showError()
}