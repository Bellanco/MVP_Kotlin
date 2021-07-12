package com.deromang.mvp_kotlin.ui.main


import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.deromang.domain.data.ResponseModel
import com.deromang.domain.data.ResultModel
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.dependencies.app.preferences.Preferences
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentModule
import com.deromang.mvp_kotlin.ui.base.BaseApplication
import com.deromang.mvp_kotlin.ui.base.BaseFragment
import com.deromang.mvp_kotlin.ui.main.adapter.MainAdapter
import com.deromang.mvp_kotlin.ui.utils.toast
import com.deromang.presentation.presentation.main.MainFragmentPresenter
import com.deromang.presentation.presentation.main.MainFragmentView
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment(), MainFragmentView {

    private lateinit var preferences: Preferences

    private var component: MainFragmentComponent? = null

    @Inject
    lateinit var presenter: MainFragmentPresenter

    companion object {

        private const val IS_ACCESS = "isAccess"

        fun newInstance(): Fragment {
            val fragment = MainFragment()
            val args = Bundle()
            args.putBoolean(IS_ACCESS, false)
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_main
    }

    override fun prepareInjection() {
        component =
            getActivityComponent()?.mainFragmentComponent()
                ?.mainFragmentModule(MainFragmentModule())?.build()

        component?.inject(this)

        presenter.setView(this)

        (activity?.application as BaseApplication).preferences?.let { preferencesApp ->
            preferences = preferencesApp
        }


        setupView()
    }

    private fun setupView() {

        presenter.getAPIService()

        presenter.showModel()

        svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { text ->
                    if (newText.isNotBlank())
                        searchModel(text)
                }
                Log.e("queryText1", newText!!);
                return false;
            }

        })
    }

    private fun searchModel(text: String) {
        presenter.searchModel(text)
    }

    override fun onShowModelReady(list: ResponseModel?) {

        rvItems.layoutManager = GridLayoutManager(context, 2)

        rvItems.adapter = MainAdapter(list?.results, context, object : MainAdapter.OnClickListener {
            override fun onClick(model: ResultModel) {
                saveResult(model)
            }
        })
    }

    private fun saveResult(model: ResultModel) {
        val results = preferences.results
        results.add(model)
        preferences.results = results
    }

    override fun showError() {
        context?.toast(getString(R.string.error))
    }


}
