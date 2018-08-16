package com.mauricio.recyclerviewsample.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.*
import android.view.Menu
import android.view.MenuItem
import com.mauricio.recyclerviewsample.R
import com.mauricio.recyclerviewsample.data.ListType
import com.mauricio.recyclerviewsample.data.Quote
import com.mauricio.recyclerviewsample.ui.settings.SettingsPrefActivity
import com.mauricio.recyclerviewsample.utils.QuoteActionListener
import kotlinx.android.synthetic.main.actv_main.*

class MainActivity : AppCompatActivity(), QuoteActionListener {

    private lateinit var viewModel: QuotesViewModel
    private lateinit var adapter: QuoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actv_main)

        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(QuotesViewModel::class.java)

        buildAdapter(viewModel.lisType)

        fab.setOnClickListener {
            viewModel.generateQuote()
        }
    }

    private fun buildAdapter(lisType: LiveData<ListType>) {
        lisType.observe(this, Observer {
            val layoutManager = getLayoutManager(it!!)
            rvQuotes.layoutManager = layoutManager

            if (it == ListType.LIST) {
                rvQuotes.addItemDecoration(DividerItemDecoration(this,
                        (layoutManager as LinearLayoutManager).orientation))
            } else if (rvQuotes.itemDecorationCount > 0) {
                rvQuotes.removeItemDecorationAt(0)
            }

            adapter = QuoteAdapter(it, this)

            rvQuotes.adapter = adapter

            observeItems()
        })
    }

    private fun observeItems() {
        viewModel.quotes.observe(this, Observer { items ->
            items?.let {
                adapter.setItems(items)
                adapter.notifyDataSetChanged()
            }
        })
    }


    private fun getLayoutManager(listType: ListType): RecyclerView.LayoutManager = when (listType) {
        ListType.LIST -> LinearLayoutManager(this)
        ListType.GRID -> GridLayoutManager(this, 2)
        ListType.STAGGERED_GRID -> StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == R.id.action_settings) {
            startActivity(Intent(this, SettingsPrefActivity::class.java))
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCopyQuote(quote: Quote) {
        viewModel.copyQuote(quote)
    }

    override fun onDeleteQuote(quote: Quote) {
        viewModel.deleteQuote(quote)
    }
}
