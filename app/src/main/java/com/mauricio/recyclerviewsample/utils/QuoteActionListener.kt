package com.mauricio.recyclerviewsample.utils

import com.mauricio.recyclerviewsample.data.Quote

interface QuoteActionListener {
    fun onCopyQuote(quote: Quote)
    fun onDeleteQuote(quote: Quote)
}