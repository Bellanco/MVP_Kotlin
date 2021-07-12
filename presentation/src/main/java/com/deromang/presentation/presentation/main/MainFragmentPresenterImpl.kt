package com.deromang.presentation.presentation.main

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

class MainFragmentPresenterImpl @Inject constructor(private var navigator: Navigator) :
    MainFragmentPresenter, BasePresenterImpl<MainFragmentView>() {

    private var mApiService: APIService? = null

    lateinit var mView: MainFragmentView

    override fun setView(view: MainFragmentView) {
        this.mView = view
    }

    override fun getAPIService() {
        mApiService = APIClient.getAPIService()
    }

    override fun showModel() {
        mApiService?.showModel(getAPIKey())
            ?.enqueue(object : Callback<ResponseModel?> {
                override fun onFailure(
                    call: Call<ResponseModel?>,
                    t: Throwable
                ) {
                    mView.showError()
                }

                override fun onResponse(
                    call: Call<ResponseModel?>,
                    response: Response<ResponseModel?>
                ) {
                    val list = response.body()
                    mView.onShowModelReady(list)
                }
            })
    }

    override fun searchModel(text: String) {
        mApiService?.searchModel(getAPIKey(), text)
            ?.enqueue(object : Callback<ResponseModel?> {
                override fun onFailure(
                    call: Call<ResponseModel?>,
                    t: Throwable
                ) {
                    mView.showError()
                }

                override fun onResponse(
                    call: Call<ResponseModel?>,
                    response: Response<ResponseModel?>
                ) {
                    val list = response.body()
                    mView.onShowModelReady(list)
                }
            })
    }

}