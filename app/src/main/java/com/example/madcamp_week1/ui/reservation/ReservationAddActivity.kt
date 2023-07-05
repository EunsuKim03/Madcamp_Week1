package com.example.madcamp_week1.ui.reservation

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityGalleryAddBinding
import com.example.madcamp_week1.databinding.ActivityReservationAddBinding
import com.example.madcamp_week1.db.contactRoom.ContactDatabase
import com.example.madcamp_week1.db.contactRoom.ContactEntity
import com.example.madcamp_week1.db.reservationRoom.ReservationDatabase
import com.example.madcamp_week1.db.reservationRoom.ReservationEntity
import com.example.madcamp_week1.db.restaurantRoom.RestaurantDatabase
import com.example.madcamp_week1.db.restaurantRoom.RestaurantEntity
import kotlinx.coroutines.runBlocking
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ReservationAddActivity : AppCompatActivity() {
    private lateinit var binding : ActivityReservationAddBinding

    lateinit var contact_db: ContactDatabase
    lateinit var restaurant_db: RestaurantDatabase
    lateinit var reservation_db: ReservationDatabase
    lateinit var dialog_restaurant: AlertDialog
    lateinit var dialog_friends: AlertDialog

    var restaurantOn = false
    var peopleOn = false

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        contact_db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contactDB"
        ).build()

        restaurant_db = Room.databaseBuilder(
            applicationContext,
            RestaurantDatabase::class.java, "restaurantDB"
        ).build()

        reservation_db = Room.databaseBuilder(
            applicationContext,
            ReservationDatabase::class.java, "reservationDB"
        ).build()

        setContentView(R.layout.activity_reservation_add)

        binding = ActivityReservationAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val date = binding.editReservationDate
        val restaurant = binding.editReservationRestaurant
        val addFriends = binding.tvButtonAddFriends
        val done = binding.editReservationDone
        val cancel = binding.editReservationCancel
        val container = binding.llRsvAddContainer

        var selectedContactIds = ArrayList<Int>()
        var selectedContactBooleanArrayList = ArrayList<Boolean>()
        var textViewArray = ArrayList<Int>()
        var cIdList = ArrayList<Int>()

        // Todo: Datatype 지정
        var dateVar: String = ""
        var restaurantVar: String = ""

        // date 저장
        val dateInputPattern = DateTimeFormatter.ofPattern("yyyy/M/d")
        val dateOutputPattern = DateTimeFormatter.ofPattern("yyyy/MM/dd")
        dateVar = date.year.toString()+"/"+(date.month+1).toString()+"/"+date.dayOfMonth.toString()
        var date_temp = LocalDate.parse(dateVar, dateInputPattern)
        dateVar = date_temp.format(dateOutputPattern)

        val restaurantList = ArrayList<RestaurantEntity>()
        runBlocking {
            val temp = restaurant_db.restaurantDao().getAll()
            temp.forEach { restaurantList.add(it) }
        }

        val contactList = ArrayList<ContactEntity>()
        runBlocking {
            val temp = contact_db.contactDao().getAll()
            temp.forEach {
                contactList.add(it)
                selectedContactBooleanArrayList.add(false)
            }
        }

        date.setOnDateChangedListener { date, year, month, dayOfMonth ->
            dateVar = date.year.toString() + "/" + (date.month + 1).toString() + "/" + date.dayOfMonth.toString()
            date_temp = LocalDate.parse(dateVar, dateInputPattern)
            dateVar = date_temp.format(dateOutputPattern)
            if (restaurantOn && peopleOn) {
                done.setBackgroundColor(Color.parseColor("#6D7EFD"))
            } else {
                done.setBackgroundColor(Color.parseColor("#D0D0D0"))
            }
        }

        restaurant.setOnClickListener {
            val rNameList: Array<String> = restaurantList.map { it.name }.toTypedArray()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Select restaurant")
            builder.setSingleChoiceItems(rNameList, -1) { _, which ->
                restaurant.setText(rNameList[which])

                restaurantVar = rNameList[which]
                restaurantOn = true
                if (restaurantOn && peopleOn) {
                    done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                } else {
                    done.setBackgroundColor(Color.parseColor("#D0D0D0"))
                }
                dialog_restaurant.dismiss()
            }

            dialog_restaurant = builder.create()
            dialog_restaurant.show()
        }

        addFriends.setOnClickListener {
            val cNameList = ArrayList<String>()

            contactList.forEach {
                cNameList.add(it.name + " (" + it.phoneNumber + ")")
                cIdList.add(it.cid)
            }

            for(j in selectedContactBooleanArrayList.indices) {
                if(textViewArray.contains(j) && selectedContactBooleanArrayList[j] == true) {
                    container.removeView(findViewById(j))
                    textViewArray.remove(j)
                }
                selectedContactBooleanArrayList[j] = false
            }
            peopleOn = false
            done.setBackgroundColor(Color.parseColor("#D0D0D0"))

            var tempBooleanArray = selectedContactBooleanArrayList.toBooleanArray()

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Select friends")
            builder.setMultiChoiceItems(cNameList.toTypedArray(), tempBooleanArray) { dialog_friends, which, isChecked ->
                tempBooleanArray[which] = isChecked
            }

            builder.setPositiveButton("DONE") { dialogInterface, i ->
                for(j in tempBooleanArray.indices) {
                    selectedContactBooleanArrayList[j] = tempBooleanArray[j]
                }
                for(j in selectedContactBooleanArrayList.indices) {
                    if(selectedContactBooleanArrayList[j]) {
                        val txt = cNameList[j].split(" ")[0]
                        val textView = TextView(applicationContext)
                        textView.setText(txt)
                        textView.textSize = 12f
//                        textView.setTextColor(Color.BLACK)
                        textView.setTextColor(Color.parseColor("#E45477"))
                        textView.setBackgroundResource(R.drawable.circular_dynamic)
//                        textView.setBackground(R.drawable.circular)
                        textView.id = j

                        textView.setPadding(16, 8, 16, 8)


                        val param : LinearLayout.LayoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                        param.marginStart = 8
                        param.marginEnd = 8
                        param.topMargin = 8
                        param.bottomMargin = 8
                        param.gravity = Gravity.CENTER

                        textView.layoutParams = param

                        textViewArray.add(textView.id)
                        container.addView(textView)

                        peopleOn = peopleOn || selectedContactBooleanArrayList[j]
                        if (restaurantOn && peopleOn) {
                            done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                        } else {
                            done.setBackgroundColor(Color.parseColor("#D0D0D0"))
                        }
                    }
                }
            }

            builder.show()

        }

        // check the condition and validate the button

        done.setOnClickListener {
            if (restaurantOn && peopleOn) {
                val selectedRestaurant: RestaurantEntity
                runBlocking { selectedRestaurant = restaurant_db.restaurantDao().getByName(restaurantVar) }
                var selectedContacts = ArrayList<ContactEntity>()
                for(j in selectedContactBooleanArrayList.indices) {
                    if(selectedContactBooleanArrayList[j]) {
                        runBlocking { selectedContacts.add(contact_db.contactDao().getById(cIdList[j])) }
                    }
                }

                runBlocking { reservation_db.reservationDao().insert(ReservationEntity(selectedRestaurant, selectedContacts.toList(), dateVar)) }
                finish()
            }
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