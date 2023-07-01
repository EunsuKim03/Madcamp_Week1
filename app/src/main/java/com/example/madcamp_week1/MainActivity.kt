package com.example.madcamp_week1

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.madcamp_week1.databinding.ActivityMainBinding
import com.example.madcamp_week1.ui.ViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.pager.adapter = ViewPagerAdapter(this)

        binding.pager.registerOnPageChangeCallback(
            object: ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.navView.menu.getItem(position).isChecked = true
                }
            }
        )

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navi_contact -> {
                    binding.pager.currentItem = 0
                    return@setOnItemSelectedListener true
                }
                R.id.navi_gallery -> {
                    binding.pager.currentItem = 1
                    return@setOnItemSelectedListener true
                }
                R.id.navi_reservation -> {
                    binding.pager.currentItem = 2
                    return@setOnItemSelectedListener true
                }
                else -> {
                    binding.pager.currentItem = 3
                    return@setOnItemSelectedListener false
                }
            }
        }

//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navi_contact, R.id.navi_gallery, R.id.navi_reservation
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }


}


