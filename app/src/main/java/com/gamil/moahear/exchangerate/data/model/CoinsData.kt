package com.gamil.moahear.exchangerate.data.model


import com.google.gson.annotations.SerializedName

data class CoinsData(
    @SerializedName("Data")
    val `data`: List<Data?>?,
    @SerializedName("HasWarning")
    val hasWarning: Boolean?, // false
    @SerializedName("Message")
    val message: String?, // Success
    @SerializedName("MetaData")
    val metaData: MetaData?,
    @SerializedName("RateLimit")
    val rateLimit: RateLimit?,
    @SerializedName("SponsoredData")
    val sponsoredData: List<Any?>?,
    @SerializedName("Type")
    val type: Int? // 100
) {
    data class Data(
        @SerializedName("CoinInfo")
        val coinInfo: CoinInfo?,
        @SerializedName("DISPLAY")
        val dISPLAY: DISPLAY?,
        @SerializedName("RAW")
        val rAW: RAW?
    ) {
        data class CoinInfo(
            @SerializedName("Algorithm")
            val algorithm: String?, // SHA-256
            @SerializedName("AssetLaunchDate")
            val assetLaunchDate: String?, // 2009-01-03
            @SerializedName("BlockNumber")
            val blockNumber: Int?, // 786260
            @SerializedName("BlockReward")
            val blockReward: Double?, // 6.25
            @SerializedName("BlockTime")
            val blockTime: Int?, // 577
            @SerializedName("DocumentType")
            val documentType: String?, // Webpagecoinp
            @SerializedName("FullName")
            val fullName: String?, // Bitcoin
            @SerializedName("Id")
            val id: String?, // 1182
            @SerializedName("ImageUrl")
            val imageUrl: String?, // /media/37746251/btc.png
            @SerializedName("Internal")
            val `internal`: String?, // BTC
            @SerializedName("MaxSupply")
            val maxSupply: Double?, // 20999999.9769
            @SerializedName("Name")
            val name: String?, // BTC
            @SerializedName("NetHashesPerSecond")
            val netHashesPerSecond: Int?, // 329334223015112000000
            @SerializedName("ProofType")
            val proofType: String?, // PoW
            @SerializedName("Rating")
            val rating: Rating?,
            @SerializedName("Type")
            val type: Int?, // 1
            @SerializedName("Url")
            val url: String? // /coins/btc/overview
        ) {
            data class Rating(
                @SerializedName("Weiss")
                val weiss: Weiss?
            ) {
                data class Weiss(
                    @SerializedName("MarketPerformanceRating")
                    val marketPerformanceRating: String?, // D
                    @SerializedName("Rating")
                    val rating: String?, // B+
                    @SerializedName("TechnologyAdoptionRating")
                    val technologyAdoptionRating: String? // A-
                )
            }
        }

        data class DISPLAY(
            @SerializedName("USD")
            val uSD: USD?
        ) {
            data class USD(
                @SerializedName("CHANGE24HOUR")
                val cHANGE24HOUR: String?, // $ -585.37
                @SerializedName("CHANGEDAY")
                val cHANGEDAY: String?, // $ 8.21
                @SerializedName("CHANGEHOUR")
                val cHANGEHOUR: String?, // $ 5.03
                @SerializedName("CHANGEPCT24HOUR")
                val cHANGEPCT24HOUR: String?, // -1.99
                @SerializedName("CHANGEPCTDAY")
                val cHANGEPCTDAY: String?, // 0.03
                @SerializedName("CHANGEPCTHOUR")
                val cHANGEPCTHOUR: String?, // 0.02
                @SerializedName("CIRCULATINGSUPPLY")
                val cIRCULATINGSUPPLY: String?, // Ƀ 19,351,631.0
                @SerializedName("CIRCULATINGSUPPLYMKTCAP")
                val cIRCULATINGSUPPLYMKTCAP: String?, // $ 558.02 B
                @SerializedName("CONVERSIONLASTUPDATE")
                val cONVERSIONLASTUPDATE: String?, // Just now
                @SerializedName("CONVERSIONSYMBOL")
                val cONVERSIONSYMBOL: String?,
                @SerializedName("CONVERSIONTYPE")
                val cONVERSIONTYPE: String?, // direct
                @SerializedName("FROMSYMBOL")
                val fROMSYMBOL: String?, // Ƀ
                @SerializedName("HIGH24HOUR")
                val hIGH24HOUR: String?, // $ 29,455.1
                @SerializedName("HIGHDAY")
                val hIGHDAY: String?, // $ 29,094.5
                @SerializedName("HIGHHOUR")
                val hIGHHOUR: String?, // $ 28,856.7
                @SerializedName("IMAGEURL")
                val iMAGEURL: String?, // /media/37746251/btc.png
                @SerializedName("LASTMARKET")
                val lASTMARKET: String?, // binanceusa
                @SerializedName("LASTTRADEID")
                val lASTTRADEID: String?, // 14094585
                @SerializedName("LASTUPDATE")
                val lASTUPDATE: String?, // Just now
                @SerializedName("LASTVOLUME")
                val lASTVOLUME: String?, // Ƀ 0.01397
                @SerializedName("LASTVOLUMETO")
                val lASTVOLUMETO: String?, // $ 403.00
                @SerializedName("LOW24HOUR")
                val lOW24HOUR: String?, // $ 28,350.1
                @SerializedName("LOWDAY")
                val lOWDAY: String?, // $ 28,406.4
                @SerializedName("LOWHOUR")
                val lOWHOUR: String?, // $ 28,783.3
                @SerializedName("MARKET")
                val mARKET: String?, // CryptoCompare Index
                @SerializedName("MKTCAP")
                val mKTCAP: String?, // $ 558.02 B
                @SerializedName("MKTCAPPENALTY")
                val mKTCAPPENALTY: String?, // 0 %
                @SerializedName("OPEN24HOUR")
                val oPEN24HOUR: String?, // $ 29,421.2
                @SerializedName("OPENDAY")
                val oPENDAY: String?, // $ 28,827.6
                @SerializedName("OPENHOUR")
                val oPENHOUR: String?, // $ 28,830.8
                @SerializedName("PRICE")
                val pRICE: String?, // $ 28,835.8
                @SerializedName("SUPPLY")
                val sUPPLY: String?, // Ƀ 19,351,631.0
                @SerializedName("TOPTIERVOLUME24HOUR")
                val tOPTIERVOLUME24HOUR: String?, // Ƀ 40,220.5
                @SerializedName("TOPTIERVOLUME24HOURTO")
                val tOPTIERVOLUME24HOURTO: String?, // $ 1,165,242,479.1
                @SerializedName("TOSYMBOL")
                val tOSYMBOL: String?, // $
                @SerializedName("TOTALTOPTIERVOLUME24H")
                val tOTALTOPTIERVOLUME24H: String?, // Ƀ 164.13 K
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                val tOTALTOPTIERVOLUME24HTO: String?, // $ 4.74 B
                @SerializedName("TOTALVOLUME24H")
                val tOTALVOLUME24H: String?, // Ƀ 190.56 K
                @SerializedName("TOTALVOLUME24HTO")
                val tOTALVOLUME24HTO: String?, // $ 5.50 B
                @SerializedName("VOLUME24HOUR")
                val vOLUME24HOUR: String?, // Ƀ 40,656.4
                @SerializedName("VOLUME24HOURTO")
                val vOLUME24HOURTO: String?, // $ 1,177,871,109.2
                @SerializedName("VOLUMEDAY")
                val vOLUMEDAY: String?, // Ƀ 19,828.5
                @SerializedName("VOLUMEDAYTO")
                val vOLUMEDAYTO: String?, // $ 571,382,820.4
                @SerializedName("VOLUMEHOUR")
                val vOLUMEHOUR: String?, // Ƀ 279.80
                @SerializedName("VOLUMEHOURTO")
                val vOLUMEHOURTO: String? // $ 8,063,297.4
            )
        }

        data class RAW(
            @SerializedName("USD")
            val uSD: USD?
        ) {
            data class USD(
                @SerializedName("CHANGE24HOUR")
                val cHANGE24HOUR: Double?, // -585.369999999999
                @SerializedName("CHANGEDAY")
                val cHANGEDAY: Double?, // 8.209999999999127
                @SerializedName("CHANGEHOUR")
                val cHANGEHOUR: Double?, // 5.029999999998836
                @SerializedName("CHANGEPCT24HOUR")
                val cHANGEPCT24HOUR: Double?, // -1.9896217587539824
                @SerializedName("CHANGEPCTDAY")
                val cHANGEPCTDAY: Double?, // 0.028479661324443448
                @SerializedName("CHANGEPCTHOUR")
                val cHANGEPCTHOUR: Double?, // 0.017446637741547782
                @SerializedName("CIRCULATINGSUPPLY")
                val cIRCULATINGSUPPLY: Int?, // 19351631
                @SerializedName("CIRCULATINGSUPPLYMKTCAP")
                val cIRCULATINGSUPPLYMKTCAP: Double?, // 558019761189.7999
                @SerializedName("CONVERSIONLASTUPDATE")
                val cONVERSIONLASTUPDATE: Int?, // 1681999951
                @SerializedName("CONVERSIONSYMBOL")
                val cONVERSIONSYMBOL: String?,
                @SerializedName("CONVERSIONTYPE")
                val cONVERSIONTYPE: String?, // direct
                @SerializedName("FLAGS")
                val fLAGS: String?, // 2049
                @SerializedName("FROMSYMBOL")
                val fROMSYMBOL: String?, // BTC
                @SerializedName("HIGH24HOUR")
                val hIGH24HOUR: Double?, // 29455.14
                @SerializedName("HIGHDAY")
                val hIGHDAY: Double?, // 29094.52
                @SerializedName("HIGHHOUR")
                val hIGHHOUR: Double?, // 28856.66
                @SerializedName("IMAGEURL")
                val iMAGEURL: String?, // /media/37746251/btc.png
                @SerializedName("LASTMARKET")
                val lASTMARKET: String?, // binanceusa
                @SerializedName("LASTTRADEID")
                val lASTTRADEID: String?, // 14094585
                @SerializedName("LASTUPDATE")
                val lASTUPDATE: Int?, // 1681999951
                @SerializedName("LASTVOLUME")
                val lASTVOLUME: Double?, // 0.01397
                @SerializedName("LASTVOLUMETO")
                val lASTVOLUMETO: Double?, // 402.9994353
                @SerializedName("LOW24HOUR")
                val lOW24HOUR: Double?, // 28350.06
                @SerializedName("LOWDAY")
                val lOWDAY: Double?, // 28406.4
                @SerializedName("LOWHOUR")
                val lOWHOUR: Double?, // 28783.29
                @SerializedName("MARKET")
                val mARKET: String?, // CCCAGG
                @SerializedName("MEDIAN")
                val mEDIAN: Int?, // 28834
                @SerializedName("MKTCAP")
                val mKTCAP: Double?, // 558019761189.7999
                @SerializedName("MKTCAPPENALTY")
                val mKTCAPPENALTY: Int?, // 0
                @SerializedName("OPEN24HOUR")
                val oPEN24HOUR: Double?, // 29421.17
                @SerializedName("OPENDAY")
                val oPENDAY: Double?, // 28827.59
                @SerializedName("OPENHOUR")
                val oPENHOUR: Double?, // 28830.77
                @SerializedName("PRICE")
                val pRICE: Double?, // 28835.8
                @SerializedName("SUPPLY")
                val sUPPLY: Int?, // 19351631
                @SerializedName("TOPTIERVOLUME24HOUR")
                val tOPTIERVOLUME24HOUR: Double?, // 40220.50673028001
                @SerializedName("TOPTIERVOLUME24HOURTO")
                val tOPTIERVOLUME24HOURTO: Double?, // 1165242479.0664184
                @SerializedName("TOSYMBOL")
                val tOSYMBOL: String?, // USD
                @SerializedName("TOTALTOPTIERVOLUME24H")
                val tOTALTOPTIERVOLUME24H: Double?, // 164129.19620220654
                @SerializedName("TOTALTOPTIERVOLUME24HTO")
                val tOTALTOPTIERVOLUME24HTO: Double?, // 4738248666.940998
                @SerializedName("TOTALVOLUME24H")
                val tOTALVOLUME24H: Double?, // 190555.2450312944
                @SerializedName("TOTALVOLUME24HTO")
                val tOTALVOLUME24HTO: Double?, // 5500322941.088987
                @SerializedName("TYPE")
                val tYPE: String?, // 5
                @SerializedName("VOLUME24HOUR")
                val vOLUME24HOUR: Double?, // 40656.44451611
                @SerializedName("VOLUME24HOURTO")
                val vOLUME24HOURTO: Double?, // 1177871109.193232
                @SerializedName("VOLUMEDAY")
                val vOLUMEDAY: Double?, // 19828.476993729742
                @SerializedName("VOLUMEDAYTO")
                val vOLUMEDAYTO: Double?, // 571382820.4140661
                @SerializedName("VOLUMEHOUR")
                val vOLUMEHOUR: Double?, // 279.80383347999896
                @SerializedName("VOLUMEHOURTO")
                val vOLUMEHOURTO: Double? // 8063297.359500224
            )
        }
    }

    data class MetaData(
        @SerializedName("Count")
        val count: Int? // 3325
    )

    class RateLimit
}