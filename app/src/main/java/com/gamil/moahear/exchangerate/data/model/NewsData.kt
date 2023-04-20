package com.gamil.moahear.exchangerate.data.model


import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("Data")
    val `data`: List<Data?>?,
    @SerializedName("HasWarning")
    val hasWarning: Boolean?, // false
    @SerializedName("Message")
    val message: String?, // News list successfully returned
    @SerializedName("Promoted")
    val promoted: List<Any?>?,
    @SerializedName("RateLimit")
    val rateLimit: RateLimit?,
    @SerializedName("Type")
    val type: Int? // 100
) {
    data class Data(
        @SerializedName("body")
        val body: String?, // Shiba Inu (SHIB) investors have been hit hard by the recent industry-wide crypto correction, with the token’s price momentum turning bearish. As the value of many cryptocurrencies took a dive, Shiba Inu followed suit, causing many to wonder what the next few weeks hold for this meme coin. Despite the negative trend, some traders remain hopeful that the demand zone could provide support and turn the tide. Related Reading: OKB Tallies 24% Increase But Active Addresses Fail To Keep Pace – Here’s Why On-Chain Data Signals Possible Downswing Amid the broader correction in the crypto market, Shiba Inu’s price has also taken a hit. According to CoinMarketCap, SHIB’s value is currently sitting at $0.00001091, with a 24-hour decrease of 0.62% and a 7-day decrease of 1.67%. The Shiba Inu ecosystem may face further downside as on-chain data reveals that SHIB holders are preparing to sell in the coming days. Data shows a significant decrease of 41% in Shiba Inu Network Growth since March 1, with new wallet addresses falling from 2,473 to 1,473 as of April 20. This reduction in network growth could indicate a loss of market share to other meme coins, and if the trend persists, SHIB’s price may struggle to find new buyers, leading to a potential price decline. Potential Price Movements For SHIB Based on data from IntoTheBlock’s Break-Even price distribution, Shiba Inu’s current support at $0.000011 is likely to be lost. However, the 38,000 addresses that bought 77 trillion SHIB coins in that zone may put up a strong resistance to the impending downward trend. If the bearish scenario materializes, the price of SHIB is expected to drop to $0.000009, where the 343,000 addresses holding 150 trillion SHIB may help to prevent further decline. On the other hand, if SHIB manages to overcome the bearish trend and break the $0.000012 resistance zone, it could continue its rally toward $0.000017. However, the 38,000 addresses holding 77 trillion tokens are likely to hinder the bullish momentum. Shiba Inu: More Bearish Signals On-chain data suggests that the cryptocurrency may be headed for a bearish trend. The 30-day Market Value to Realized Value (MVRV) ratio, which measures holders’ short-term profit or loss, is nearing a potential sell-zone as most holders currently sit on 6.87% profits. This puts the MVRV ratio in a high-risk territory that could signal a potential price drop. SHIB market cap at $6.4 billion on the daily chart at TradingView.com Related Reading: Cardano Racks Up Nearly 4% Gain Amid Short-Term Losses – Will Investors Hold Firm? Adding to the bearish sentiment is the slowdown in new-user acquisition rate on the Shiba Inu Network, which raises concerns about the cryptocurrency’s market share in comparison to other meme coins. SHIB’s short-term outlook appears to be bearish, with potential downside risks looming in the near future. Investors should closely monitor the MVRV ratio and new-user acquisition rate for any further signs of a price drop. -Featured image from iHeartDogs
        @SerializedName("categories")
        val categories: String?, // TRADING|SHIB|MARKET|BUSINESS|ICO
        @SerializedName("downvotes")
        val downvotes: String?, // 0
        @SerializedName("guid")
        val guid: String?, // https://www.newsbtc.com/?p=527779
        @SerializedName("id")
        val id: String?, // 11952091
        @SerializedName("imageurl")
        val imageurl: String?, // https://images.cryptocompare.com/news/default/newsbtc.png
        @SerializedName("lang")
        val lang: String?, // EN
        @SerializedName("published_on")
        val publishedOn: Int?, // 1681998176
        @SerializedName("source")
        val source: String?, // newsbtc
        @SerializedName("source_info")
        val sourceInfo: SourceInfo?,
        @SerializedName("tags")
        val tags: String?, // Cryptocurrency news|meme coins|Price action|SHIB price|Shiba Inu
        @SerializedName("title")
        val title: String?, // Shiba Inu (SHIB) Price Momentum Screeches To A Halt: What’s The Outlook?
        @SerializedName("upvotes")
        val upvotes: String?, // 0
        @SerializedName("url")
        val url: String? // https://www.newsbtc.com/news/shiba-inue-price-falters/
    ) {
        data class SourceInfo(
            @SerializedName("img")
            val img: String?, // https://images.cryptocompare.com/news/default/newsbtc.png
            @SerializedName("lang")
            val lang: String?, // EN
            @SerializedName("name")
            val name: String? // NewsBTC
        )
    }

    class RateLimit
}