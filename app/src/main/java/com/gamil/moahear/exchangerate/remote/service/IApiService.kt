package com.gamil.moahear.exchangerate.remote.service

import com.gamil.moahear.exchangerate.BuildConfig
import com.gamil.moahear.exchangerate.data.model.CoinsData
import com.gamil.moahear.exchangerate.data.model.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface IApiService {
    @Headers(BuildConfig.BASE_URL)
    @GET("v2/news/")
    fun getNews(/*@Header("api_key") apiKey:String,*/@Query("sortOrder") sortOrder:String="latest"):Call<NewsData>

    @Headers(BuildConfig.BASE_URL)
    @GET("top/totalvolfull")
fun getTopCoins(@Query("tsym") toSymbol:String="USD",@Query("limit") limit:Int=10):Call<CoinsData>
}