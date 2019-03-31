package com.sermarmu.gnbtrades.app.trades.holder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.sermarmu.gnbtrades.R
import com.sermarmu.gnbtrades.app.trades.protocols.SkuItemListener

class GNBSkuViewHolderList(inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.text_view_sku, parent, false)) {

    private var fromView : TextView? = null

    init {
        fromView = itemView.findViewById(R.id.txtViewSku)
    }

    fun bindView(sku : String, listener : SkuItemListener) {
        fromView?.text = sku
        fromView?.setOnClickListener { listener.onClickItem(sku) }
    }

}
