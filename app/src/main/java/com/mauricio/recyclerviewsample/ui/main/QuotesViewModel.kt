package com.mauricio.recyclerviewsample.ui.main

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.mauricio.recyclerviewsample.data.Quote
import com.mauricio.recyclerviewsample.utils.Injector

class QuotesViewModel(context: Application) : AndroidViewModel(context) {

    private val repository = Injector.provideDataSource(context)
    private val data = repository.bulkQuotes()
    val quotes = data.quotes
    val lisType = data.listType

    fun copyQuote(quote: Quote) = repository.copyQuote(quote)

    fun deleteQuote(quote: Quote) = repository.deleteQuote(quote)

    fun generateQuote() = repository.generateNewQuote()

}