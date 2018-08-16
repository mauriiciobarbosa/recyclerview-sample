package com.mauricio.recyclerviewsample.data.source

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


class PreferencesLiveData(context: Context, val key: String, val defaultValue: String) : MutableLiveData<String>() {

    val sharedPreferencesListener = SharedPreferences.OnSharedPreferenceChangeListener {
        sharedPreferences, changedKey ->
        if (key == changedKey) {
            val value = sharedPreferences.getString(key, defaultValue)
            postValue(value)
        }
    }

    init {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        preferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener)
        val initValue = preferences.getString(key, defaultValue)
        postValue(initValue)
    }

}