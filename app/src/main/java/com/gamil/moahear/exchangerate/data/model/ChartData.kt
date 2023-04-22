package com.gamil.moahear.exchangerate.data.model


import com.google.gson.annotations.SerializedName

data class ChartData(
    @SerializedName("Data")
    val `data`: Data?,
    @SerializedName("HasWarning")
    val hasWarning: Boolean?, // false
    @SerializedName("Message")
    val message: String?,
    @SerializedName("RateLimit")
    val rateLimit: RateLimit?,
    @SerializedName("Response")
    val response: String?, // Success
    @SerializedName("Type")
    val type: Int? // 100
) {
    data class Data(
        @SerializedName("Aggregated")
        val aggregated: Boolean?, // false
        @SerializedName("Data")
        val `data`: List<Data?>?,
        @SerializedName("TimeFrom")
        val timeFrom: Int?, // 1682074920
        @SerializedName("TimeTo")
        val timeTo: Int? // 1682075520
    ) {
        data class Data(
            @SerializedName("close")
            val close: Double?, // 22627.37
            @SerializedName("conversionSymbol")
            val conversionSymbol: String?,
            @SerializedName("conversionType")
            val conversionType: String?, // direct
            @SerializedName("high")
            val high: Double?, // 22630.65
            @SerializedName("low")
            val low: Double?, // 22622.5
            @SerializedName("open")
            val `open`: Double?, // 22630.65
            @SerializedName("time")
            val time: Int?, // 1682074920
            @SerializedName("volumefrom")
            val volumefrom: Double?, // 0.04699
            @SerializedName("volumeto")
            val volumeto: Double? // 1063.45
        )
    }

    class RateLimit
}