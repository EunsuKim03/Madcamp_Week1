package com.example.madcamp_week1.ui.contact

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityContactAddBinding
import com.example.madcamp_week1.db.contactRoom.ContactDatabase
import com.example.madcamp_week1.db.contactRoom.ContactEntity
import kotlinx.coroutines.runBlocking


class ContactAddActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContactAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_add)

        binding = ActivityContactAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.editContactName
        val phone = binding.editContactPhone
        val done = binding.editContactDone
        val cancel = binding.editContactCancel
        val image = binding.editContactImage

        // nameVar, phoneVar -> 입력값
        var nameVar: String = ""
        var phoneVar: String = ""

        var db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contactDB"
        ).build()

        name.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                nameVar = name.text.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
                nameVar = name.text.toString()
                if ((nameVar != "") && (phoneVar != "")) {
                    done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                }
            }

        })

        phone.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                phoneVar = phone.text.toString()

//                // 여기서 done 처리 할까 그냥
//                done.setBackgroundColor(Color.parseColor("#6D7EFD"))
//                // Done button listener
//                done.setOnClickListener {
////                TODO()
//                }
            }



            override fun afterTextChanged(p0: Editable?) {
                phoneVar = phone.text.toString()
                if ((nameVar != "") && (phoneVar != "")) {
                    done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                }
            }

        })

        // Image button listener
        image.setOnClickListener {
//            TODO()
        }





        // Done button listener
        done.setOnClickListener {
           runBlocking { db.contactDao().insert(ContactEntity(nameVar, "person_beenzino", phoneVar)) }
            finish()
        }

        // Cancel button listener
        cancel.setOnClickListener {
            finish()
        }

        // Toolbar
        val toolbar = binding.toolbarContactAdd
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Add contact")


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