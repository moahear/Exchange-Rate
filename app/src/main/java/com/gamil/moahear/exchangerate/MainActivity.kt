package com.gamil.moahear.exchangerate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gamil.moahear.exchangerate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

             //StringOfJsonFile.getString(this@MainActivity)

           /* Log.i("TAGFF", "onCreate: ${applicationContext.assets.open("currencyinfo.json").bufferedReader().use {br->
                br.readText()
            }}")*/
        }
    }
}