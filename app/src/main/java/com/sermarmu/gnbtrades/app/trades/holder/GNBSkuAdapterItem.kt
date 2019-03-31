package com.sermarmu.gnbtrades.app.trades.holder

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sermarmu.gnbtrades.app.trades.model.SkuModel

class GNBSkuAdapterItem(private val data: List<SkuModel>?) : RecyclerView.Adapter<GNBSkuViewHolderItem>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GNBSkuViewHolderItem {
        val inflater = LayoutInflater.from(parent.context)

        return GNBSkuViewHolderItem(inflater, parent)
    }

    override fun getItemCount(): Int {
        return data!!.size

    }

    override fun onBindViewHolder(viewHolder: GNBSkuViewHolderItem?, position: Int) {
        val skuModel: SkuModel = data!!.get(position)
        viewHolder?.bindView(skuModel)
    }
}