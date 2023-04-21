package com.gamil.moahear.exchangerate.ui.market

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gamil.moahear.exchangerate.BuildConfig
import com.gamil.moahear.exchangerate.R
import com.gamil.moahear.exchangerate.data.model.CoinsData
import com.gamil.moahear.exchangerate.databinding.ItemRvMarketBinding

class MarketAdapter : RecyclerView.Adapter<MarketAdapter.MarketViewHolder>() {
    private val coins = ArrayList<CoinsData.Data>()

    inner class MarketViewHolder(private val binding: ItemRvMarketBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bindCoin(coin: CoinsData.Data) {
            binding.apply {

                txtCoinName.text = coin.coinInfo?.fullName
                txtDollar.text = coin.coinInfo?.name
                //txtPrice.text = "$" + DecimalFormat("0.000000").format(coin.rAW?.uSD?.pRICE).dropLastWhile { it=='0' }.dropLastWhile { it=='.' }
                txtPrice.text = coin.dISPLAY?.uSD?.pRICE
                //txtMarketCap.text ="$" +DecimalFormat("0.00").format((coin.rAW?.uSD?.mKTCAP?.div(1000000000))).dropLastWhile { it=='0' }.dropLastWhile { it=='.' }+" B"
                txtMarketCap.text =coin.dISPLAY?.uSD?.mKTCAP
                coin.rAW?.uSD?.cHANGE24HOUR?.let {
                    if (it > 0) {
                        txtChange.setTextColor(
                            ContextCompat.getColor(txtChange.context, R.color.colorGain)
                        )
                    } else if (it < 0) {
                        txtChange.setTextColor(
                            ContextCompat.getColor(
                                txtChange.context,
                                R.color.colorLoss
                            )
                        )
                    }
                }
                //txtChange.text=DecimalFormat("0.00").format(coin.rAW?.uSD?.cHANGE24HOUR)
                txtChange.text=coin.dISPLAY?.uSD?.cHANGE24HOUR
                Glide.with(imgItem.context).load(
                    BuildConfig.BASE_URL_IMAGE + (coin.coinInfo?.imageUrl
                        ?: "")
                ).into(imgItem)
                root.setOnClickListener {
                    setOnCoinClickListener?.let {
                        it(coin)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        val binding =
            ItemRvMarketBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarketViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return coins.size
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        holder.bindCoin(coins[position])
    }

    private var setOnCoinClickListener: ((CoinsData.Data) -> Unit)? = null
    fun onCoinClick(listener: (CoinsData.Data) -> Unit) {
        setOnCoinClickListener = listener
    }

    private class CoinDiffUtilCallback(
        val oldList: List<CoinsData.Data>,
        val newList: List<CoinsData.Data>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] === newList[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] === newList[newItemPosition]
        }
    }

    fun submitList(newList: List<CoinsData.Data>) {
        val diffResult = DiffUtil.calculateDiff(CoinDiffUtilCallback(coins, newList))
        diffResult.dispatchUpdatesTo(this)
        coins.clear()
        coins.addAll(newList)
    }

}