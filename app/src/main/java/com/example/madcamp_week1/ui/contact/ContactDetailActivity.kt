package com.example.madcamp_week1.ui.contact

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityContactDetailBinding
import com.example.madcamp_week1.db.ContactData

class ContactDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("contactData", ContactData::class.java)
        } else {
            intent.getParcelableExtra("contactData") as? ContactData
        }

        binding.tvContactDetailName.text = data!!.name
        binding.tvContactDetailPhonenum.text = data!!.phoneNumber

    }
}