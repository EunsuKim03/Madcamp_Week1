package com.example.madcamp_week1.ui.reservation

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityContactDetailBinding
import com.example.madcamp_week1.databinding.ActivityReservationDetailBinding
import com.example.madcamp_week1.db.ContactData
import com.example.madcamp_week1.db.ReservationData
import com.example.madcamp_week1.ui.gallery.GalleryMapActivity
import com.example.madcamp_week1.ui.gallery.restaurantDataList

class ReservationDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityReservationDetailBinding
    private lateinit var list: ArrayList<ContactData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation_detail)

        binding = ActivityReservationDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("reservationData", ReservationData::class.java)
        } else {
            intent.getParcelableExtra("reservationData") as? ReservationData
        }

        var resDate = data!!.date
        val arr = resDate.split("/")
        val toolbar = binding.toolbarReservation
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("${arr[0].toInt()}년 ${arr[1].toInt()}월 ${arr[2].toInt()}일 예약")

        binding.ivRsvDetailRestaurantImg.setImageResource(this.resources.getIdentifier(data!!.restaurant.photoName, "drawable", this.packageName))
        binding.tvRsvDetailRestaurantName.text = data!!.restaurant.name
        binding.tvRsvDetailRestaurantAddr.text = data!!.restaurant.address
        binding.tvRsvDetailRestaurantPhone.text = data!!.restaurant.resPhone

        // rcv
        list = data!!.contacts
        binding.rcvRsvDetailFriends.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rcvRsvDetailFriends.setHasFixedSize(true)
        binding.rcvRsvDetailFriends.adapter = ReservationFriendsListAdapter(list)

        binding.tvRsvDetailRestaurantAddr.setOnClickListener {
            Intent(
                applicationContext,
                GalleryMapActivity::class.java
            ).apply{
                putExtra("galleryMapAddr", data!!.restaurant.address)
                putExtra("galleryMapName", data!!.restaurant.name)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run { applicationContext.startActivity(this) }
        }

        // 전화 앱 실행
        binding.tvRsvDetailRestaurantPhone.setOnClickListener {
            val dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${data!!.restaurant.resPhone.replace("-", "")}"))
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
                TODO("delete operation")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}