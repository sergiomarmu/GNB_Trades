package com.sermarmu.gnbtrades.app.trades

import android.app.Activity
import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import com.sermarmu.gnbtrades.app.trades.model.SkuTrade
import com.sermarmu.gnbtrades.utils.GNBUtils

class TradePresenterImpl(private val view: TradeContract.View) :
    TradeContract.Presenter,
    TradeContract.InteractorOutput {

    private var interactor: TradeContract.Interactor

    private var router: TradeContract.Router

    init {
        interactor = TradeInteractorImpl()
        router = TradeRouterImpl(view as Activity)
    }


    // PRESENTER
    override fun getTradesSku() {
        val data = interactor.getTradesSkuFrom()
        if (data != null) {
            tradesSuccess(data)
        }

    }

    override fun getSkuTransactions() {
        val data = interactor.getSkuFrom()
        if (data != null) {
            skuSuccess(data)
        }
    }

    override fun onDestroy() {
        TODO("not implemented") // DESTROY ACTIVITY, FRAGMENT....
    }

    // INTERACTOR OUTPUT
    override fun tradesSuccess(data: List<SkuTrade>?) {
        view.getTradeData(data)
    }

    override fun tradeFailure() {
        view.showError(GNBUtils.SERVICE_ERROR)
    }

    override fun skuSuccess(data: List<SkuModel>?) {
        view.getSkuData(data)
    }

    override fun skuFailure() {
        view.showError(GNBUtils.SERVICE_ERROR)
    }


}