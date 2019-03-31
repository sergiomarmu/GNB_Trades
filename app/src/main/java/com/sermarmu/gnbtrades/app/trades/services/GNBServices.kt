package com.sermarmu.gnbtrades.app.trades.services

import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import com.sermarmu.gnbtrades.app.trades.model.SkuTrade
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface GNBServices {
    @GET("/rates.json")
    fun getTrade(): Deferred<Response<List<SkuTrade>>>

    @GET("/transactions.json")
    fun getSku(): Deferred<Response<List<SkuModel>>>

}