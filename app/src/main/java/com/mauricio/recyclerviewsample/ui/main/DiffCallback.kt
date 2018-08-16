package com.mauricio.recyclerviewsample.ui.main

import android.support.v7.util.DiffUtil
import com.mauricio.recyclerviewsample.data.Quote

class DiffCallback : DiffUtil.ItemCallback<Quote>() {

    override fun areItemsTheSame(oldItem: Quote?, newItem: Quote?): Boolean {
        return oldItem?.id == newItem?.id
    }

    override fun areContentsTheSame(oldItem: Quote?, newItem: Quote?): Boolean {
        return oldItem == newItem
    }

}