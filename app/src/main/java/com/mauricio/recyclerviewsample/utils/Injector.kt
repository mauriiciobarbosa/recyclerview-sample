package com.mauricio.recyclerviewsample.utils

import android.annotation.SuppressLint
import android.content.Context
import com.mauricio.recyclerviewsample.data.source.QuotesRepository

object Injector {
    @SuppressLint("StaticFieldLeak")
    private var repository: QuotesRepository? = null

    fun provideDataSource(context: Context) : QuotesRepository {
        if (repository == null) {
            repository = QuotesRepository(context)
        }
        return repository!!
    }
}