package com.deromang.mvp_kotlin.dependencies.app.preferences

import android.content.Context
import android.content.SharedPreferences
import com.deromang.domain.data.ResultModel
import com.google.gson.Gson


class PreferencesImpl(context: Context) : Preferences {

    private val userSharedPreferences: SharedPreferences = context.getSharedPreferences(
        Constants.PREF_FILE_NAME, Context.MODE_PRIVATE
    )

    override var results: MutableList<ResultModel>
        get() {
            val arPoint = userSharedPreferences.getString(Constants.PREF_RESULTS, null)
            arPoint?.let { arPoint ->
                return Gson().fromJson(arPoint, Array<ResultModel>::class.java).toMutableList()
            } ?: run {
                return arrayListOf()
            }
        }
        set(value) {
            val json = Gson().toJson(value)
            userSharedPreferences.edit().putString(Constants.PREF_RESULTS, json).apply()
        }
}