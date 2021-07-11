package com.deromang.mvp_kotlin.ui.main


import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.deromang.domain.data.ResponseModel
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentComponent
import com.deromang.mvp_kotlin.dependencies.modules.presentation.main.MainFragmentModule
import com.deromang.mvp_kotlin.ui.base.BaseFragment
import com.deromang.mvp_kotlin.ui.main.adapter.MainAdapter
import com.deromang.mvp_kotlin.ui.utils.addItems
import com.deromang.mvp_kotlin.ui.utils.loadImageFromUrl
import com.deromang.mvp_kotlin.ui.utils.toast
import com.deromang.presentation.presentation.main.MainFragmentPresenter
import com.deromang.presentation.presentation.main.MainFragmentView
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : BaseFragment(), MainFragmentView {

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

        setupView()
    }

    private fun setupView() {

        presenter.getAPIService()

        presenter.showLeagues()

        val url =
            "https://media.moddb.com/images/members/1/414/413573/profile/thewitcheranniversary_610.jpg"
        ivBackground.loadImageFromUrl(url)

        val items = addItems()

    }

    override fun onShowLeaguesReady(list: ResponseModel?) {

        rvItems.layoutManager = GridLayoutManager(context, 2)

        rvItems.adapter = MainAdapter(list?.competitions, context)
    }

    override fun showError() {
        context?.toast(getString(R.string.error))
    }


}
