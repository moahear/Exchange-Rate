package com.gamil.moahear.exchangerate.ui.coin

import com.gamil.moahear.exchangerate.data.model.ChartData
import com.robinhood.spark.SparkAdapter

class CoinSparkAdapter(
    private val historicalData: List<ChartData.Data.Data>,
    private val baseline: String?
) : SparkAdapter() {
    override fun getCount(): Int {
        return historicalData.size
    }

    override fun getItem(index: Int): ChartData.Data.Data {
        return historicalData[index]
    }

    override fun getY(index: Int): Float {
        return historicalData[index].close?.toFloat() ?: 0f
    }

    override fun hasBaseLine(): Boolean {
        return true
    }

    override fun getBaseLine(): Float {
        return baseline?.toFloat() ?: super.getBaseLine()
    }
}