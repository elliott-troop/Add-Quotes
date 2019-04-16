package com.elliott.quotesmvvm.data

//Repositories are the mediators between model/remote data source and viewmodels
//they will always take in a data access object
//where the viewmodel gets data

class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    //returns the casted LiveData from the dao
    fun getQuotes() = quoteDao.getQuotes()

    //FakeRepository will be a singleton
    companion object {

        //writes to this field are immediately made visible to other threads
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }
    }
}