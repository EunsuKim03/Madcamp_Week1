package com.example.madcamp_week1.ui.gallery

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityContactAddBinding
import com.example.madcamp_week1.databinding.ActivityGalleryAddBinding
import com.example.madcamp_week1.db.contactRoom.ContactDatabase
import com.example.madcamp_week1.db.contactRoom.ContactEntity
import com.example.madcamp_week1.db.restaurantRoom.RestaurantDatabase
import com.example.madcamp_week1.db.restaurantRoom.RestaurantEntity
import kotlinx.coroutines.runBlocking

class GalleryAddActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGalleryAddBinding
    private var imageUri: Uri? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery_add)

        binding = ActivityGalleryAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.editGalleryName
        val addr = binding.editGalleryAddress
        val phone = binding.editGalleryPhone
        val done = binding.editGalleryDone
        val cancel = binding.editGalleryCancel
        val image = binding.editGalleryImage

        // nameVar, addrVar, phoneVar -> 입력값
        var nameVar: String = ""
        var addrVar: String = ""
        var phoneVar: String = ""

        var db = Room.databaseBuilder(
            applicationContext,
            RestaurantDatabase::class.java, "restaurantDB"
        ).build()

        name.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                nameVar = name.text.toString()
                if ((nameVar != "") && (phoneVar != "") && (addrVar != "")) {
                    done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                } else {
                    done.setBackgroundColor(Color.parseColor("#D0D0D0"))
                }
            }

        })

        addr.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                addrVar = addr.text.toString()
                if ((nameVar != "") && (phoneVar != "") && (addrVar != "")) {
                    done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                } else {
                    done.setBackgroundColor(Color.parseColor("#D0D0D0"))
                }
            }

        })

        phone.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                phoneVar = phone.text.toString()
                if ((nameVar != "") && (phoneVar != "") && (addrVar != "")) {
                    done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                } else {
                    done.setBackgroundColor(Color.parseColor("#D0D0D0"))
                }
            }

        })

        // Image button listener
        image.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            activityResult.launch(intent)
        }

        // Done button listener
        done.setOnClickListener {
            if (imageUri != null) {
                applicationContext.grantUriPermission(applicationContext.packageName, imageUri!!, Intent.FLAG_GRANT_READ_URI_PERMISSION)
                runBlocking { db.restaurantDao().insert(RestaurantEntity(nameVar, imageUri.toString(), phoneVar, addrVar)) }
                finish()
            }
        }

        // Cancel button listener
        cancel.setOnClickListener {
            finish()
        }


        // Toolbar
        val toolbar = binding.toolbarGalleryAdd
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Add photo")

    }

    private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        if(it.resultCode == RESULT_OK && it.data != null) {
            val uri = it.data!!.data
            imageUri = uri
            Glide.with(this)
                .load(uri)
                .into(binding.editGalleryImage)
        }
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