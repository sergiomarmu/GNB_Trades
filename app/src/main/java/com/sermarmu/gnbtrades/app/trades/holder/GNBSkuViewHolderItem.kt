package com.sermarmu.gnbtrades.app.trades.holder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.sermarmu.gnbtrades.R
import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import com.sermarmu.gnbtrades.utils.GNBUtils

class GNBSkuViewHolderItem(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.text_view_sku, parent, false)) {
    private var skuView: TextView? = null

    init {
        skuView = itemView.findViewById(R.id.txtViewSku)
    }

    fun bindView(skuModel: SkuModel) {
        skuView?.text = skuModel.amount + GNBUtils.EMPTY_SPACE + skuModel.currency

    }

}