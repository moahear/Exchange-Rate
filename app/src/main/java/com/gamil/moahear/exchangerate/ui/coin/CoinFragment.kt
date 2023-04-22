package com.gamil.moahear.exchangerate.ui.coin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gamil.moahear.exchangerate.BuildConfig
import com.gamil.moahear.exchangerate.R
import com.gamil.moahear.exchangerate.data.model.ChartData
import com.gamil.moahear.exchangerate.databinding.FragmentCoinBinding
import com.gamil.moahear.exchangerate.remote.client.ApiClient
import com.gamil.moahear.exchangerate.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoinFragment : Fragment() {
    private val navArgs: CoinFragmentArgs by navArgs()
    private lateinit var binding: FragmentCoinBinding
    private var histoPeriod: String = Constants.HISTO_MINUTE
    private var aggregate: Int = 12
    private var limit: Int = 60
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //region Show data in chart
        getChartInfo()
        //endregion
        binding.apply {
            //region Set title of toolbar
            layoutToolbar.toolbar.title = navArgs.bundleCoin?.coinInfo?.fullName
            //endregion
            //region Show data in layoutStatistics
            layoutStatistics.apply {
                txtOpenAmount.text = navArgs.bundleCoin?.dISPLAY?.uSD?.oPEN24HOUR
                txtTodayHighAmount.text = navArgs.bundleCoin?.dISPLAY?.uSD?.hIGH24HOUR
                txtTodayLowAmount.text = navArgs.bundleCoin?.dISPLAY?.uSD?.lOW24HOUR
                txtTodayChangeAmount.text = navArgs.bundleCoin?.dISPLAY?.uSD?.cHANGE24HOUR
                txtAlgorithmAmount.text = navArgs.bundleCoin?.coinInfo?.algorithm
                txtTotalVolumeAmount.text = navArgs.bundleCoin?.dISPLAY?.uSD?.tOTALVOLUME24H
                txtMarketCapAmount.text = navArgs.bundleCoin?.dISPLAY?.uSD?.mKTCAP
                txtSupplyAmount.text = navArgs.bundleCoin?.dISPLAY?.uSD?.sUPPLY
            }
            //endregion
            //region Show data in layoutAbout
            layoutAbout.apply {
                txtGithub.text = navArgs.bundleCoinAbout?.info?.github
                txtReddit.text = navArgs.bundleCoinAbout?.info?.reddit
                txtTwitter.text = "@" + navArgs.bundleCoinAbout?.info?.twt
                txtAboutCoin.text = navArgs.bundleCoinAbout?.info?.desc
                txtWebsite.text = navArgs.bundleCoinAbout?.info?.web

                txtGithub.setOnClickListener {
                    Intent(Intent.ACTION_VIEW, txtGithub.text.toString().toUri()).apply {
                        startActivity(this)
                    }
                }

                txtReddit.setOnClickListener {
                    Intent(Intent.ACTION_VIEW, txtReddit.text.toString().toUri()).apply {
                        startActivity(this)
                    }
                }
                txtTwitter.setOnClickListener {
                    Intent(
                        Intent.ACTION_VIEW,
                        (BuildConfig.BASE_URL_TWITTER + navArgs.bundleCoinAbout?.info?.twt).toUri()
                    ).apply {
                        startActivity(this)
                    }
                }
                txtWebsite.setOnClickListener {
                    Intent(Intent.ACTION_VIEW, txtWebsite.text.toString().toUri()).apply {
                        startActivity(this)
                    }
                }
            }
            //endregion
            //region Show data in layoutChart
            layoutChart.apply {
                sparkChart.setScrubListener {
                    if (it != null) txtChartPrice.text = ("$ " + (it as ChartData.Data.Data).close)
                    else txtChartPrice.text = navArgs.bundleCoin?.dISPLAY?.uSD?.pRICE

                }
                txtChartPrice.text = navArgs.bundleCoin?.dISPLAY?.uSD?.pRICE
                // Change text color txtChartChangePercent and txtChartUpDown if greeter than zero or less than zero
                val change24Hour = navArgs.bundleCoin?.dISPLAY?.uSD?.cHANGE24HOUR?.replace("$", "")
                    ?.trim()
                    ?.toFloat() ?: 0f
                when {
                    change24Hour > 0 -> {
                        txtChartChangePercent.setTextColor(
                            ContextCompat.getColor(
                                txtChartChangePercent.context,
                                R.color.colorGain
                            )
                        )
                        txtChartUpDown.text = "▲"
                        txtChartUpDown.setTextColor(
                            ContextCompat.getColor(
                                txtChartChangePercent.context,
                                R.color.colorGain
                            )
                        )
                        sparkChart.lineColor =
                            ContextCompat.getColor(txtChartChangePercent.context, R.color.colorGain)
                    }
                    change24Hour < 0 -> {
                        sparkChart.lineColor =
                            ContextCompat.getColor(txtChartChangePercent.context, R.color.colorLoss)
                        txtChartUpDown.text = "▼"
                        txtChartChangePercent.setTextColor(
                            ContextCompat.getColor(
                                txtChartChangePercent.context,
                                R.color.colorLoss
                            )
                        )
                        txtChartUpDown.setTextColor(
                            ContextCompat.getColor(
                                txtChartChangePercent.context,
                                R.color.colorLoss
                            )
                        )
                    }
                    else -> {}
                }

                txtChartChangeDollar.text = navArgs.bundleCoin?.dISPLAY?.uSD?.cHANGE24HOUR
                txtChartChangePercent.text = navArgs.bundleCoin?.dISPLAY?.uSD?.cHANGEPCT24HOUR + "%"

                radioGroupChart.setOnCheckedChangeListener { group, checkedId ->
                    when (checkedId) {
                        R.id.rdb_12h -> {
                            histoPeriod = Constants.HISTO_MINUTE
                            limit = 60
                            aggregate = 12
                        }
                        R.id.rdb_1day -> {
                            histoPeriod = Constants.HISTO_DAY
                            limit = 24
                            aggregate = 1
                        }
                        R.id.rdb_1week -> {
                            histoPeriod = Constants.HISTO_DAY
                            limit = 7
                            aggregate = 1
                        }
                        R.id.rdb_1month -> {
                            histoPeriod = Constants.HISTO_DAY
                            limit = 30
                            aggregate = 1
                        }
                        R.id.rdb_3month -> {
                            histoPeriod = Constants.HISTO_DAY
                            limit = 90
                            aggregate = 1
                        }
                        R.id.rdb_1year -> {
                            histoPeriod = Constants.HISTO_DAY
                            limit = 30
                            aggregate = 13
                        }
                        R.id.rdb_all -> {
                            histoPeriod = Constants.HISTO_DAY
                            limit = 2000
                            aggregate = 30
                        }
                    }
                    getChartInfo()
                }
            }
            //endregion
        }
    }

    //region get data for chart with retrofit enqueue
    private fun getChartInfo() {
        ApiClient.apiService.getChartData(
            period = histoPeriod,
            limit = limit,
            aggregate = aggregate,
            fromSymbol = navArgs.bundleCoin?.coinInfo?.name.toString()
        ).enqueue(object : Callback<ChartData> {
            override fun onResponse(call: Call<ChartData>, response: Response<ChartData>) {
                val data = response.body()?.data?.data?.maxByOrNull {
                    it?.close?.toFloat() ?: 0f
                }
                val coinSparkAdapter = CoinSparkAdapter(
                    response.body()?.data?.data as List<ChartData.Data.Data>,
                    data?.open.toString()
                )
                binding.apply {
                    layoutChart.sparkChart.adapter = coinSparkAdapter
                }
            }

            override fun onFailure(call: Call<ChartData>, t: Throwable) {
                Toast.makeText(context, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    //endregion
}