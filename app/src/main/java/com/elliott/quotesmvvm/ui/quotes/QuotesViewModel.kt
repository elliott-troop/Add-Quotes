package com.elliott.quotesmvvm.ui.quotes

import androidx.lifecycle.ViewModel
import com.elliott.quotesmvvm.data.Quote
import com.elliott.quotesmvvm.data.QuoteRepository

//Viewmodels should always have repositories as an parameter

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)

}