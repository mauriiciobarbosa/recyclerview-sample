package com.mauricio.recyclerviewsample.data.source

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.content.Context
import com.mauricio.recyclerviewsample.R
import com.mauricio.recyclerviewsample.data.ListType
import com.mauricio.recyclerviewsample.data.Listing
import com.mauricio.recyclerviewsample.data.Quote

class QuotesRepository(private val context: Context) {

    private val inMemory = InMemoryDataSource()

    val quotes = MutableLiveData<List<Quote>>()
    private val preferencesListType = PreferencesLiveData(context, context.getString(R.string.key_layout_manager), "1")
    private val listType = Transformations.map(preferencesListType, { ListType.getById(it) })!!

    init {
        quotes.value = inMemory.bulkQuotes()
    }

    fun bulkQuotes(): Listing {
        return Listing(quotes = quotes,
                listType = listType)
    }

    fun generateNewQuote() {
        val newQuote = inMemory.getQuoteFromPool()
        quotes.value = quotes.value!! + newQuote
    }

    fun copyQuote(quote: Quote) {
        val newQuote = inMemory.copyQuote(quote)
        quotes.value = quotes.value!! + newQuote
    }

    fun deleteQuote(quote: Quote) {
        inMemory.addQuoteToPool(quote)
        quotes.value = quotes.value!! - quote
    }

}