package com.sermarmu .gnbtrades.app.trades.holder

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.sermarmu.gnbtrades.R
import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import kotlinx.android.synthetic.main.dialog_data_type.view.*


class GNBDialog : DialogFragment(), AdapterView.OnItemSelectedListener {

    private var skuListType: List<SkuModel>? = null
    private var titleDialog: String? = null
    private var listDialogSpinner: List<String>? = null
    private var totalAmount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val dialogTrade: View = inflater!!.inflate(R.layout.dialog_data_type, container, false)

        dialogTrade.titleDialogView.text = titleDialog

        val adapder =
            ArrayAdapter(context, android.R.layout.simple_spinner_item, listDialogSpinner)
        adapder.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dialogTrade.txtViewDialogSpinnerCurrency.adapter = adapder
        dialogTrade.txtViewDialogSpinnerCurrency.onItemSelectedListener = this

        totalAmount = dialogTrade.txtViewDialogTotalProduct

        dialogTrade.recyclerViewSku.layoutManager = LinearLayoutManager(context)
        dialogTrade.recyclerViewSku.adapter = GNBSkuAdapterItem(skuListType)

        return dialogTrade
    }


    fun setData(title: String, listSku: List<SkuModel>?, listMoney: List<String>?) {
        titleDialog = title
        skuListType = listSku
        listDialogSpinner = listMoney
    }

    override fun onItemSelected(arg0: AdapterView<*>, arg1: View, position: Int, id: Long) {
        totalAmount?.text  = listDialogSpinner?.get(position)
    }

    override fun onNothingSelected(arg0: AdapterView<*>) {

    }
}