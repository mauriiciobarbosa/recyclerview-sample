package com.mauricio.recyclerviewsample.data.source

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


class PreferencesLiveData<T>(context: Context,
                             private val key: String,
                             private val defaultValue: T) : MutableLiveData<T>() {

    private val sharedPreferencesListener = SharedPreferences.OnSharedPreferenceChangeListener {
        preferences, changedKey ->
        if (key == changedKey) {
            notifyObservers(preferences)
        }
    }

    init {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        preferences.registerOnSharedPreferenceChangeListener(sharedPreferencesListener)
        notifyObservers(preferences)
    }

    private fun notifyObservers(preferences: SharedPreferences) {
        val initValue = preferences.all[key] as T ?: defaultValue
        postValue(initValue)
    }

}