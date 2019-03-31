package com.sermarmu.gnbtrades.utils

import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import com.sermarmu.gnbtrades.app.trades.model.SkuTrade
import java.math.RoundingMode
import java.text.DecimalFormat

class GNBUtils {
    companion object {

        const val EMPTY_SPACE = " "

        const val CURRENCY_ZERO = 0.00

        const val CURRENCY_ONE = 1.00

        const val SERVICE_ERROR = 0

        val dF = DecimalFormat("#.##")

        fun filterByMoney(gnbMoney: List<SkuTrade>?): List<String>? {
            val listMoney: MutableList<String> = mutableListOf()

            gnbMoney?.forEach {
                var value: String?

                value = it.from
                if (!listMoney.contains(value)) listMoney += value

                value = it.to
                if (!listMoney.contains(value)) listMoney += value
            }

            return listMoney
        }

        fun filterByProduct(gnbProduct: List<SkuModel>?): List<String>? {
            val listProduct: MutableList<String> = mutableListOf()

            gnbProduct?.forEach {
                var value: String?

                value = it.sku
                if (!listProduct.contains(value)) listProduct += value
            }

            return listProduct
        }

        fun filterByProductType(gnbMoney: List<SkuModel>?, type: String): List<SkuModel>? {
            val listProductsByType: MutableList<SkuModel> = mutableListOf()

            gnbMoney?.forEach {
                var value: String?

                value = it.sku
                if (type.equals(value)) listProductsByType.add(it)
            }

            return listProductsByType
        }

        fun getCurrentMoneyValues(gnbMoney: List<SkuTrade>?): MutableMap<String, MutableMap<String, Double>>? {
            val listMoneyType = this.filterByMoney(gnbMoney)
            val listMoney: MutableMap<String, MutableMap<String, Double>>? = mutableMapOf()


            listMoneyType?.forEach {
                val type = it
                var listMoneyCurrencies: MutableMap<String, Double> = mutableMapOf()
                listMoneyType?.forEach {
                    val currentType = it
                    listMoneyCurrencies.put(currentType, CURRENCY_ZERO)
                }
                if (!listMoney?.containsKey(type)!!)
                    listMoney.put(type, listMoneyCurrencies)
            }

            val tableCurrency = listMoney

            gnbMoney?.forEach {
                val skuTrade = it
                listMoney?.forEach {
                    val currencyType = it
                    if (skuTrade.from.equals(currencyType.key))
                        currencyType.value.put(skuTrade.to, skuTrade.rate)
                }

                listMoney?.get(skuTrade.from)?.put(skuTrade.from, CURRENCY_ONE)
            }

            val tableCurrencyConvert = tableCurrency

            tableCurrency?.forEach {
                val type = it
                type.value.forEach {
                    val typeZero = it
                    if (typeZero.value == this.CURRENCY_ZERO) {
                        tableCurrencyConvert?.forEach {
                            val typeToLook = it
                            if (typeToLook.value.containsKey(type.key)) {
                                if (typeToLook.value.containsKey(typeZero.key)) {
                                    if (!(typeToLook.value.get(typeZero.key)!! == this.CURRENCY_ZERO)) {
                                        if (!(typeToLook.value.get(type.key)!! == this.CURRENCY_ZERO)) {
                                            dF.roundingMode = RoundingMode.CEILING
                                            tableCurrency?.get(type.key)?.put(
                                                typeZero.key,
                                                dF.format(
                                                    1 / typeToLook.value.get(type.key)!!
                                                        .plus(typeToLook.value.get(typeZero.key)!!)
                                                ).toDouble()
                                            )
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
            }


            return listMoney
        }


        fun sumTotalAmountByCurrency(currency: String,
                                    currencyTable: MutableMap<String, MutableMap<String, Double>>?,
                                    skuList: List<SkuModel>?) {
        }

    }
}