package com.elliott.quotesmvvm.data

//constructor is private so it cannot be invoked outside of this class

class FakeDatabase private constructor() {

    var quoteDao = FakeQuoteDao()
    private set

    //FakeDatabase will be a singleton
    companion object {

        //writes to this field are immediately made visible to other threads
        @Volatile private var instance: FakeDatabase? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: FakeDatabase().also { instance = it }
                }
    }
}