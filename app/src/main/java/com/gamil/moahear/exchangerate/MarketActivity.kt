package com.gamil.moahear.exchangerate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gamil.moahear.exchangerate.databinding.ActivityMarketBinding

class MarketActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMarketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

        }
    }
}