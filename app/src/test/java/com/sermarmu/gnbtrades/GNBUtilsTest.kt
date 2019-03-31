package com.sermarmu.gnbtrades

import com.sermarmu.gnbtrades.app.trades.model.SkuModel
import com.sermarmu.gnbtrades.app.trades.model.SkuTrade
import com.sermarmu.gnbtrades.utils.GNBUtils
import org.junit.Before
import org.junit.Test

class GNBUtilsTest {

    var gnbMoneyFromService: List<SkuTrade>? = null
    var gnbProductFromService: List<SkuModel>? = null
    var listMoneyFilterCurrency: List<String>? = null
    var listProductFilterCurrency: List<String>? = null
    val skuModel = SkuModel("Product1", "50", "EUR")
    var listProductByTypeFilterCurrency: List<SkuModel>? = null

    @Before
    fun setUp() {
        gnbMoneyFromService = listOf(
            SkuTrade("EUR", "USD", 0.50),
            SkuTrade("CAD", "AUD", 0.56)
        )
        listMoneyFilterCurrency = listOf("EUR", "USD", "CAD", "AUD")
        gnbProductFromService = listOf(
            SkuModel("Product1", "50", "EUR"),
            SkuModel("Product2", "24", "USD")
        )
        listProductFilterCurrency = listOf("Product1", "Product2")
        listProductByTypeFilterCurrency = listOf(skuModel)
    }

    @Test
    fun checkIfUtilsFilterByMoneyWorkFine() {
        assert(GNBUtils.filterByMoney(gnbMoneyFromService) == listMoneyFilterCurrency)
    }

    @Test
    fun checkIfUtilsFilterByProductWorkFine() {
        assert(GNBUtils.filterByProduct(gnbProductFromService) == listProductFilterCurrency)
    }

    @Test
    fun checkIfUtilsFilterByPproductTypeWorkFine() {
        assert(GNBUtils.filterByProductType(gnbProductFromService, "Product1") == listProductByTypeFilterCurrency)
    }
}