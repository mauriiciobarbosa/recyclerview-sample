package com.mauricio.recyclerviewsample.data

import android.arch.lifecycle.LiveData

class Listing(val quotes: LiveData<List<Quote>>,
              val listType: LiveData<ListType>)