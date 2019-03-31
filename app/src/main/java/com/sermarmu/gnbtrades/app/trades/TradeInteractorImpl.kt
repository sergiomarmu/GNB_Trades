package com.sermarmu.gnbtrades.app.trades

import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import com.sermarmu.gnbtrades.app.trades.services.GNBFactoryServices
import com.sermarmu.gnbtrades.app.trades.model.SkuTrade
import kotlinx.coroutines.*

class TradeInteractorImpl : TradeContract.Interactor {

    override fun getTradesSkuFrom(): List<SkuTrade>? = runBlocking {
        val service = GNBFactoryServices.makeGNBTradeService()
        val request = service.getTrade()
        request.await().body()
    }

    override fun getSkuFrom(): List<SkuModel>? = runBlocking {
        val service = GNBFactoryServices.makeGNBTSkuService()
        val request = service.getSku()
        request.await().body()
    }
}
