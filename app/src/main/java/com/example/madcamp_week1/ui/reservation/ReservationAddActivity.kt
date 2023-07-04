package com.example.madcamp_week1.ui.reservation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityGalleryAddBinding
import com.example.madcamp_week1.databinding.ActivityReservationAddBinding

class ReservationAddActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReservationAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_add)

        binding = ActivityReservationAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val date = binding.editReservationDate
        val restaurant = binding.editReservationRestaurant
        val peopleList = binding.editReservationList
        val done = binding.editReservationDone
        val cancel = binding.editReservationCancel

        // Todo: Datatype 지정
        var dateVar: String = ""
        var restaurantVar: String = ""
        var peopleListVar: String = ""

        // date 저장
        dateVar = date.year.toString()+"/"+(date.month+1).toString()+"/"+date.dayOfMonth.toString()



        done.setOnClickListener {
            TODO()
        }

        // Cancel button listener
        cancel.setOnClickListener {
            finish()
        }

        // Toolbar
        val toolbar = binding.toolbarReservationAdd
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Make reservation")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}