package com.assessment.universityandroid.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assessment.universityandroid.detail.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var intent = intent
        var b = intent.getBundleExtra("Data_Key")
        if (b != null) {
            binding.txtUniName.text = b.getString("name")
            binding.txtUniState.text = b.getString("state")
            binding.txtCountry.text = b.getString("country")
            binding.txtCountryCode.text = b.getString("country_code")
            binding.txtWebpage.text = b.getString("web_pages")
        }
        binding.imgRefresh.setOnClickListener{
            this.finish()
        }


    }
}