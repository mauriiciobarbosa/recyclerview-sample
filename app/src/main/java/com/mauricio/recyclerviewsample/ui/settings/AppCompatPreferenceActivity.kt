package com.mauricio.recyclerviewsample.ui.settings

import android.content.res.Configuration
import android.preference.PreferenceActivity
import android.support.v7.app.AppCompatDelegate
import android.view.ViewGroup
import android.support.annotation.LayoutRes
import android.view.MenuInflater
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.View


open class AppCompatPreferenceActivity : PreferenceActivity() {

    private var mDelegate: AppCompatDelegate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        getDelegate().installViewFactory()
        getDelegate().onCreate(savedInstanceState)
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        getDelegate().onPostCreate(savedInstanceState)
    }

    fun getSupportActionBar(): ActionBar? {
        return getDelegate().supportActionBar
    }

    fun setSupportActionBar(@Nullable toolbar: Toolbar) {
        getDelegate().setSupportActionBar(toolbar)
    }

    override fun getMenuInflater(): MenuInflater {
        return getDelegate().menuInflater
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        getDelegate().setContentView(layoutResID)
    }

    override fun setContentView(view: View) {
        getDelegate().setContentView(view)
    }

    override fun setContentView(view: View, params: ViewGroup.LayoutParams) {
        getDelegate().setContentView(view, params)
    }

    override fun addContentView(view: View, params: ViewGroup.LayoutParams) {
        getDelegate().addContentView(view, params)
    }

    override fun onPostResume() {
        super.onPostResume()
        getDelegate().onPostResume()
    }

    override fun onTitleChanged(title: CharSequence, color: Int) {
        super.onTitleChanged(title, color)
        getDelegate().setTitle(title)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        getDelegate().onConfigurationChanged(newConfig)
    }

    override fun onStop() {
        super.onStop()
        getDelegate().onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        getDelegate().onDestroy()
    }

    override fun invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu()
    }

    private fun getDelegate(): AppCompatDelegate {
        if (mDelegate == null) {
            mDelegate = AppCompatDelegate.create(this, null)
        }
        return mDelegate!!
    }
}