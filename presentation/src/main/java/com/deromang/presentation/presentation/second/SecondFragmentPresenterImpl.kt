package com.deromang.presentation.presentation.second

import com.deromang.domain.data.ResponseModel
import com.deromang.domain.modules.api.APIClient
import com.deromang.domain.modules.api.APIService
import com.deromang.presentation.navigation.Navigator
import com.deromang.presentation.presentation.base.BasePresenterImpl
import com.deromang.presentation.presentation.constants.getAPIKey
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SecondFragmentPresenterImpl @Inject constructor(private var navigator: Navigator) :
    SecondFragmentPresenter, BasePresenterImpl<SecondFragmentView>() {

    private var mApiService: APIService? = null

    lateinit var mView: SecondFragmentView

    override fun setView(view: SecondFragmentView) {
        this.mView = view
    }

    override fun getAPIService() {
        mApiService = APIClient.getAPIService()
    }

}