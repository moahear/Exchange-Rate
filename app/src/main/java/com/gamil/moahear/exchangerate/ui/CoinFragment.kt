package com.gamil.moahear.exchangerate.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gamil.moahear.exchangerate.BuildConfig
import com.gamil.moahear.exchangerate.databinding.FragmentCoinBinding

class CoinFragment : Fragment() {
    private val navArgs: CoinFragmentArgs by navArgs()
    private lateinit var binding: FragmentCoinBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCoinBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            layoutToolbar.toolbar.title = navArgs.bundleCoin?.coinInfo?.fullName
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
        }
    }
}