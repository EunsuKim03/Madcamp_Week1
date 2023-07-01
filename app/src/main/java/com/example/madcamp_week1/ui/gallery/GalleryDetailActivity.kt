package com.example.madcamp_week1.ui.gallery

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityGalleryDetailBinding
import com.example.madcamp_week1.db.RestaurantList

class GalleryDetailActivity : AppCompatActivity(){
    private lateinit var binding : ActivityGalleryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_detail)

        binding = ActivityGalleryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val resId = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.getIntExtra("galleryData1", 0)
        } else {
            null
        }

        val position = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.getIntExtra("galleryData2", 0)
        } else {
            null
        }

        binding.galleryDetailPhoto.setImageResource(resId!!)
        binding.galleryDetailAddress.text = RestaurantList[position!!].address
        binding.galleryDetailName.text = RestaurantList[position!!].name
        binding.galleryDetailPhone.text = RestaurantList[position!!].resPhone

    }
}