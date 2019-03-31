package com.sermarmu.gnbtrades.app.trades.services

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object GNBFactoryServices {
    const val URL_BASE = "http://quiet-stone-2094.herokuapp.com"

    fun makeGNBTradeService(): GNBServices {
        return Retrofit.Builder().baseUrl(URL_BASE)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(GNBServices::class.java)
    }

    fun makeGNBTSkuService(): GNBServices {
        return Retrofit.Builder().baseUrl(URL_BASE)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build().create(GNBServices::class.java)
    }

}