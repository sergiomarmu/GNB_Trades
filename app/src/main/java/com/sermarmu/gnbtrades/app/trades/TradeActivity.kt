package com.sermarmu.gnbtrades.app.trades

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.sermarmu.gnbtrades.R
import com.sermarmu.gnbtrades.app.trades.holder.GNBDialog
import com.sermarmu.gnbtrades.app.trades.holder.GNBSkuAdapterList
import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import com.sermarmu.gnbtrades.app.trades.model.SkuTrade
import com.sermarmu.gnbtrades.app.trades.protocols.SkuItemListener
import com.sermarmu.gnbtrades.utils.GNBUtils
import kotlinx.android.synthetic.main.activity_trade.*

class TradeActivity : AppCompatActivity(), TradeContract.View, SkuItemListener {

    private lateinit var presenter: TradeContract.Presenter

    private var skuTradeData: List<SkuTrade>? = null
    private var skuData: List<SkuModel>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trade)

        init()
    }

    private fun init() {
        presenter = TradePresenterImpl(this)
        presenter.getTradesSku()
        presenter.getSkuTransactions()
        GNBUtils.getCurrentMoneyValues(skuTradeData)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = GNBSkuAdapterList(GNBUtils.filterByProduct(skuData), this)
    }

    override fun onDestroyView() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showError(id: Int) {
        val msg = resources.getString(id)
        val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun getTradeData(gnbSku: List<SkuTrade>?) {
        skuTradeData = gnbSku
    }

    override fun getSkuData(gnbSkuData: List<SkuModel>?) {
        skuData = gnbSkuData
    }

    override fun onClickItem(skuType: String) {
        println(skuType)
        val manager = supportFragmentManager
        val frag = GNBDialog()
        frag.setData(skuType, GNBUtils.filterByProductType(skuData, skuType), GNBUtils.filterByMoney(skuTradeData))
        frag.show(manager, "frag")
    }

}
