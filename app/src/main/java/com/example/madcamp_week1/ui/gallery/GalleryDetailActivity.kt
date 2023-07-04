package com.example.madcamp_week1.ui.gallery

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityGalleryDetailBinding
import com.example.madcamp_week1.db.restaurantRoom.RestaurantDatabase
import com.example.madcamp_week1.db.restaurantRoom.RestaurantEntity
import kotlinx.coroutines.runBlocking

class GalleryDetailActivity : AppCompatActivity(){
    lateinit var db: RestaurantDatabase
    var rtid = -1
    private lateinit var binding : ActivityGalleryDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            RestaurantDatabase::class.java, "restaurantDB"
        ).build()

        setContentView(R.layout.activity_gallery_detail)

        binding = ActivityGalleryDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val resId = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            intent.getIntExtra("galleryData1", 0)
//        } else {
//            null
//        }
//
//        val position = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            intent.getIntExtra("galleryData2", 0)
//        } else {
//            null
//        }

        rtid = intent.getIntExtra("rtid", -1)
        val name = intent.getStringExtra("restaurantName")
        val photoName = intent.getStringExtra("restaurantPhoto")
        val phone = intent.getStringExtra("restaurantPhone")
        val address = intent.getStringExtra("restaurantAddress")


//        binding.galleryDetailPhoto.setImageResource(resId!!)
//        binding.galleryDetailAddress.text = restaurantDataList[position!!].address
//        binding.galleryDetailName.text = restaurantDataList[position!!].name
//        binding.galleryDetailPhone.text = restaurantDataList[position!!].resPhone

        binding.galleryDetailName.text = name
        Glide.with(applicationContext)
            .load(Uri.parse(photoName))
            .into(binding.galleryDetailPhoto)
        binding.galleryDetailPhone.text = phone
        binding.galleryDetailAddress.text = address

        // Toolbar
        val toolbar = binding.toolbarGallery
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(name)


        // Map 실행
        binding.galleryDetailAddress.setOnClickListener {
            Intent(
                applicationContext,
                GalleryMapActivity::class.java
            ).apply{
                putExtra("galleryMapAddr", address)
                putExtra("galleryMapName", name)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run { applicationContext.startActivity(this) }
        }

        // 전화 앱 실행
        binding.galleryDetailPhone.setOnClickListener {
            val dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${phone!!.replace("-", "")}"))
            startActivity(dial)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_delete_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.toolbar_delete -> {
                val temp: RestaurantEntity
                if(rtid != -1) {
                    runBlocking { temp = db.restaurantDao().getById(rtid) }
                    runBlocking { db.restaurantDao().delete(temp)}
                    Toast.makeText(this, "Successfully deleted!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}