package com.gamil.moahear.exchangerate.utils

import android.content.Context
import com.gamil.moahear.exchangerate.data.model.CoinAboutParcelable
import com.google.gson.Gson

object CoinsAbout {
    fun getCoinsAbout(context: Context): CoinAboutParcelable {
        val stringOfJsonFile = context.assets.open("currencyinfo.json").bufferedReader().use { br ->
            br.readText()
        }
        val gson = Gson()
        return gson.fromJson(stringOfJsonFile, CoinAboutParcelable::class.java)
    }
}