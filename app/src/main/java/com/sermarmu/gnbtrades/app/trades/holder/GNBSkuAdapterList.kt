package com.sermarmu.gnbtrades.app.trades.holder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sermarmu.gnbtrades.app.trades.protocols.SkuItemListener

class GNBSkuAdapterList(
    private val skuDataType: List<String>?,
    private val listener: SkuItemListener
) : RecyclerView.Adapter<GNBSkuViewHolderList>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GNBSkuViewHolderList {
        val inflater = LayoutInflater.from(parent.context)

        return GNBSkuViewHolderList(inflater, parent)
    }

    override fun getItemCount(): Int {
        return skuDataType!!.size
    }

    override fun onBindViewHolder(viewHolder: GNBSkuViewHolderList, position: Int) {
        val trade: String = skuDataType!![position]
        viewHolder.bindView(trade, listener)
    }

}