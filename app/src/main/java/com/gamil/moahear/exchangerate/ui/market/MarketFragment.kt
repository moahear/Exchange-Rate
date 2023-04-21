package com.gamil.moahear.exchangerate.ui.market

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gamil.moahear.exchangerate.data.model.CoinsData
import com.gamil.moahear.exchangerate.data.model.NewsData
import com.gamil.moahear.exchangerate.databinding.FragmentMarketBinding
import com.gamil.moahear.exchangerate.remote.client.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketFragment : Fragment() {
    private val marketAdapter by lazy {
        MarketAdapter()
    }
    private lateinit var binding: FragmentMarketBinding
    private lateinit var randomPair:Pair<String?,String?>
    val dataToSend: ArrayList<Pair<String?, String?>> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMarketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            layoutToolbar.toolbar.title = "Exchange Rate"
            loadData()
            layoutNews.root.setOnClickListener {
                randomPair=dataToSend.random()
                layoutNews.txtNews.text = randomPair.first
            }
            layoutNews.imgNews.setOnClickListener {
                Intent(Intent.ACTION_VIEW,randomPair.second?.toUri()).apply {
                    startActivity(this)
                }
            }
            layoutShowList.btnShowMore.setOnClickListener {
                Intent(Intent.ACTION_VIEW,"https://www.livecoinwatch.com/".toUri()).apply {
                    startActivity(this)
                }
            }
            swipeRefreshMarket.setOnRefreshListener {
                Handler(Looper.getMainLooper()).postDelayed({
                    loadData()
                    swipeRefreshMarket.isRefreshing=false
                },1000)

            }
        }
        marketAdapter.onCoinClick {
            findNavController().navigate(MarketFragmentDirections.actionMarketFragmentToCoinFragment())
        }
    }

    private fun FragmentMarketBinding.loadData() {
        ApiClient.apiService.getNews("popular").enqueue(object : Callback<NewsData> {
            override fun onResponse(call: Call<NewsData>, response: Response<NewsData>) {
                response.body()?.let {
                    it.data?.let { newsList ->
                        newsList.forEach { news ->
                            news?.let { dataToSend.add(Pair(news.title, news.url)) }
                        }
                    }
                }
                randomPair = dataToSend.random()
                layoutNews.txtNews.text = randomPair.first

            }

            override fun onFailure(call: Call<NewsData>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_LONG).show()
            }

        })
        ApiClient.apiService.getTopCoins().enqueue(object : Callback<CoinsData> {
            override fun onResponse(call: Call<CoinsData>, response: Response<CoinsData>) {
                response.body()?.data?.let {
                    layoutShowList.rvMarket.apply {
                        layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                        it.let {
                            marketAdapter.submitList(it as List<CoinsData.Data>)
                            Log.i("TAGA", "onResponse: $it")
                        }
                        adapter = marketAdapter
                    }
                }
            }

            override fun onFailure(call: Call<CoinsData>, t: Throwable) {
                Log.i("TAGA", "onFailure: ${t.message}")
            }

        })
    }
}