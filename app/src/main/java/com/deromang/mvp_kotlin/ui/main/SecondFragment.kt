package com.deromang.mvp_kotlin.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.deromang.domain.data.ResultModel
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.dependencies.app.preferences.Preferences
import com.deromang.mvp_kotlin.dependencies.modules.presentation.second.SecondFragmentComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.second.SecondFragmentModule
import com.deromang.mvp_kotlin.ui.base.BaseApplication
import com.deromang.mvp_kotlin.ui.base.BaseFragment
import com.deromang.mvp_kotlin.ui.main.adapter.MainAdapter
import com.deromang.presentation.presentation.second.SecondFragmentPresenter
import com.deromang.presentation.presentation.second.SecondFragmentView
import kotlinx.android.synthetic.main.fragment_second.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class SecondFragment : BaseFragment(), SecondFragmentView {

    private lateinit var preferences: Preferences

    private var component: SecondFragmentComponent? = null

    @Inject
    lateinit var presenter: SecondFragmentPresenter

    companion object {

        private const val IS_ACCESS = "isAccess"

        fun newInstance(): Fragment {
            val fragment = SecondFragment()
            val args = Bundle()
            args.putBoolean(IS_ACCESS, false)
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_second
    }

    override fun prepareInjection() {
        component =
            getActivityComponent()?.secondFragmentComponent()
                ?.mainFragmentModule(SecondFragmentModule())?.build()

        component?.inject(this)

        presenter.setView(this)

        (activity?.application as BaseApplication).preferences?.let { preferencesApp ->
            preferences = preferencesApp
        }

        setupView()
    }

    private fun setupView() {
        presenter.getAPIService()
    }

    override fun onResume() {
        super.onResume()
        onShowModelReady(preferences.results)

    }

    private fun onShowModelReady(results: MutableList<ResultModel>) {

        rvItems.layoutManager = LinearLayoutManager(context)

        rvItems.adapter = MainAdapter(results, context, object : MainAdapter.OnClickListener {
            override fun onClick(model: ResultModel) {
            }

        })
    }


}
