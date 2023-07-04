package com.example.madcamp_week1

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.madcamp_week1.databinding.ActivityMainBinding
import com.example.madcamp_week1.ui.ViewPagerAdapter
import com.example.madcamp_week1.ui.contact.ContactAddActivity
import com.example.madcamp_week1.ui.gallery.GalleryAddActivity
import com.example.madcamp_week1.ui.reservation.ReservationAddActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentPage = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        currentPage = 0

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED
            || ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            var permissions = arrayOf(
                android.Manifest.permission.READ_MEDIA_IMAGES,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
            ActivityCompat.requestPermissions(this, permissions, 99)
        }

        // ToolBar
        val toolbar = findViewById<Toolbar>(R.id.toolbar_main_activity)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // ViewPager2
        binding.pager.adapter = ViewPagerAdapter(this)

        binding.pager.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    currentPage = position
                    super.onPageSelected(position)
                    binding.toolbarMainActivityTitle.text = when(position) {
                        0 ->  "Contact"
                        1 ->  "Gallery"
                        else -> "Reservation"
                    }
                    binding.navView.menu.getItem(position).isChecked = true
                }
            }
        )

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navi_contact -> {
                    binding.toolbarMainActivityTitle.text = "Contact"
                    binding.pager.currentItem = 0
                    currentPage = 0
                    return@setOnItemSelectedListener true
                }
                R.id.navi_gallery -> {
                    currentPage = 1
                    binding.toolbarMainActivityTitle.text = "Gallery"
                    binding.pager.currentItem = 1
                    return@setOnItemSelectedListener true
                }
                R.id.navi_reservation -> {
                    currentPage = 2
                    binding.toolbarMainActivityTitle.text = "Reservation"
                    binding.pager.currentItem = 2
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.pager.currentItem = 3
                    return@setOnItemSelectedListener false
                }
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_add_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            R.id.toolbar_add -> {
                when(currentPage) {
                    0 -> {
                        Intent(this, ContactAddActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }.run { applicationContext.startActivity(this) }
                        return true
                    }
                    1 -> {
                        Intent(this, GalleryAddActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }.run { applicationContext.startActivity(this) }
                    }
                    2 -> {
                        Intent(this, ReservationAddActivity::class.java).apply {
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }.run { applicationContext.startActivity(this) }
                    }
                }

            }
        }
        return super.onOptionsItemSelected(item)
    }


}


