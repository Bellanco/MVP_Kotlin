package com.deromang.mvp_kotlin.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.ui.activity.MainActivity
import com.deromang.mvp_kotlin.ui.main.MainFragment
import com.deromang.presentation.navigation.Navigator

class NavigatorImpl(private var activity: AppCompatActivity) : Navigator {

    val CONTAINER_ID = R.id.container

    override fun goBack() {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivity(intent)
    }

    override fun onBackPressed() {
        activity.supportFragmentManager.popBackStackImmediate()
    }

    override fun goToMainFragment() {
        activity.supportFragmentManager.popBackStackImmediate(
            null,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        replaceFragment(MainFragment.newInstance(), false)
    }

    private fun replaceFragment(fragment: Fragment, addToBack: Boolean) {
        val fragmentManager = activity.supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()


        if (addToBack) {
            fragmentTransaction.addToBackStack(null)
        }

        fragmentTransaction.replace(CONTAINER_ID, fragment)
        fragmentTransaction.commit()
    }

}