package com.deromang.mvp_kotlin.dependencies.app.preferences

import com.deromang.domain.data.ResultModel

interface Preferences {

    var results: MutableList<ResultModel>

}