package com.example.madcamp_week1.ui.contact

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.PhoneNumberFormattingTextWatcher
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.room.Room
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityContactAddBinding
import com.example.madcamp_week1.db.contactRoom.ContactDatabase
import com.example.madcamp_week1.db.contactRoom.ContactEntity
import kotlinx.coroutines.runBlocking


class ContactAddActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContactAddBinding
    private var imageUri: Uri? = null

    var valid = false

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
                    valid = true
                } else {
                    done.setBackgroundColor(Color.parseColor("#D0D0D0"))
                    valid = false
                }
            }

        })

        phone.addTextChangedListener(PhoneNumberFormattingTextWatcher())

        phone.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun afterTextChanged(p0: Editable?) {
                phoneVar = phone.text.toString()
                if ((nameVar != "") && (phoneVar != "")) {
                    done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                    valid = true
                } else {
                    done.setBackgroundColor(Color.parseColor("#D0D0D0"))
                    valid = false
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
            if (imageUri != null && valid) {
                applicationContext.grantUriPermission(applicationContext.packageName, imageUri!!, Intent.FLAG_GRANT_READ_URI_PERMISSION)
                runBlocking { db.contactDao().insert(ContactEntity(nameVar, imageUri.toString(), phoneVar)) }
                finish()
            }
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

    private val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK && it.data != null) {
                val uri = it.data!!.data
                imageUri = uri
                Glide.with(this)
                    .load(uri)
                    .circleCrop()
                    .into(binding.editContactImage)
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