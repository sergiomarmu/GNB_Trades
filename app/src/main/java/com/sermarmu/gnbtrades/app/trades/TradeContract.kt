package com.sermarmu.gnbtrades.app.trades

import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import com.sermarmu.gnbtrades.app.trades.model.SkuTrade

class TradeContract {

    interface View {
        fun onDestroyView()
        fun showError(id: Int)
        fun getTradeData(gnbSku: List<SkuTrade>?)
        fun getSkuData(gnbSkuData: List<SkuModel>?)
    }

    interface Presenter {
        fun getTradesSku()
        fun getSkuTransactions()
        fun onDestroy()
    }

    interface Interactor {
        fun getTradesSkuFrom(): List<SkuTrade>?
        fun getSkuFrom(): List<SkuModel>?
    }

    interface InteractorOutput {
        fun tradesSuccess(data: List<SkuTrade>?)
        fun tradeFailure()
        fun skuSuccess(data: List<SkuModel>?)
        fun skuFailure()
    }

    interface Router {
        fun navigateTo()
    }
}