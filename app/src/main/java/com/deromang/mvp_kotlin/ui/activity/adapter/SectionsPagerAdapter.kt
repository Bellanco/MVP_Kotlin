package com.deromang.mvp_kotlin.ui.activity.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.ui.main.MainFragment
import com.deromang.mvp_kotlin.ui.main.SecondFragment

private val TAB_TITLES = arrayOf(
    R.string.label_popular,
    R.string.label_favourite
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return if (position == 0)
            MainFragment.newInstance()
        else
            SecondFragment.newInstance()

    }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}
