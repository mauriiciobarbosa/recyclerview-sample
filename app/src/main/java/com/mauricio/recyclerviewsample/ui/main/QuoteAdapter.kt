package com.mauricio.recyclerviewsample.ui.main

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mauricio.recyclerviewsample.R
import com.mauricio.recyclerviewsample.data.ListType
import com.mauricio.recyclerviewsample.data.Quote
import com.mauricio.recyclerviewsample.utils.QuoteActionListener
import kotlinx.android.synthetic.main.item_card_view.view.copy_quote as quoteCardCopyButton
import kotlinx.android.synthetic.main.item_card_view.view.delete_quote as quoteCardDeleteButton
import kotlinx.android.synthetic.main.item_card_view.view.quote_desc as quoteCardDesc
import kotlinx.android.synthetic.main.item_card_view.view.quote_title as quoteCardTitle
import kotlinx.android.synthetic.main.item_line_view.view.copy_quote as quoteCopyButton
import kotlinx.android.synthetic.main.item_line_view.view.delete_quote as quoteDeleteButton
import kotlinx.android.synthetic.main.item_line_view.view.quote_title as quoteTitle

/**
 * Created by mauricio on 07/05/18.
 */
class QuoteAdapter(private val listType: ListType,
                   private val listener: QuoteActionListener)
    : ListAdapter<Quote, QuoteAdapter.QuoteViewHolder>(DiffCallback()) {

    fun setItems(newItems: List<Quote>) {
        submitList(newItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        if (listType == ListType.LIST) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_line_view, null, false)
            return QuoteViewHolder.LineQuoteViewHolder(view)
        }

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_view, null, false)
        return QuoteViewHolder.GridQuoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    sealed class QuoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        abstract fun bind(quote: Quote, listener: QuoteActionListener)

        class LineQuoteViewHolder(view: View) : QuoteViewHolder(view) {
            override fun bind(quote: Quote, listener: QuoteActionListener) {
                itemView.apply {
                    quoteTitle.text = quote.author
                    quoteCopyButton.setOnClickListener {
                        listener.onCopyQuote(quote)
                    }
                    quoteDeleteButton.setOnClickListener {
                        listener.onDeleteQuote(quote)
                    }
                }
            }
        }

        class GridQuoteViewHolder(view: View) : QuoteViewHolder(view) {
            override fun bind(quote: Quote, listener: QuoteActionListener) {
                itemView.apply {
                    quoteCardTitle.text = quote.author
                    quoteCardDesc.text = quote.description
                    quoteCardCopyButton.setOnClickListener {
                        listener.onCopyQuote(quote)
                    }
                    quoteCardDeleteButton.setOnClickListener {
                        listener.onDeleteQuote(quote)
                    }
                }
            }
        }
    }

}