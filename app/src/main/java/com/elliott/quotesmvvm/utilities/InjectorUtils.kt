package com.elliott.quotesmvvm.utilities

import com.elliott.quotesmvvm.data.FakeDatabase
import com.elliott.quotesmvvm.data.FakeQuoteDao
import com.elliott.quotesmvvm.data.QuoteRepository
import com.elliott.quotesmvvm.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory() : QuotesViewModelFactory {
        val quotesRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quotesRepository)
    }
}