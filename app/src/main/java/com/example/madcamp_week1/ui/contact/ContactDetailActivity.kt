package com.example.madcamp_week1.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityContactDetailBinding
import com.example.madcamp_week1.db.ContactData
import com.example.madcamp_week1.ui.gallery.GalleryMapActivity

class ContactDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val data = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            intent.getParcelableExtra("contactData", ContactData::class.java)
//        } else {
//            intent.getParcelableExtra("contactData") as? ContactData
//        }
//
//        binding.tvContactDetailName.text = data!!.name
//        binding.tvContactDetailPhonenum.text = data!!.phoneNumber
//        if(data!!.photoName == "") {
//            binding.ivContactDetailProfile.setImageResource(this.resources.getIdentifier("ic_contact_profile", "drawable", this.packageName))
//        } else {
//            binding.ivContactDetailProfile.setImageResource(this.resources.getIdentifier(data!!.photoName, "drawable", this.packageName))
//        }
        val name = intent.getStringExtra("name")
        val photoName = intent.getStringExtra("photoName")
        val phoneNumber = intent.getStringExtra("phoneNumber")

        binding.tvContactDetailName.text = name
        binding.tvContactDetailPhonenum.text = phoneNumber

        if(photoName == "") {
            binding.ivContactDetailProfile.setImageResource(this.resources.getIdentifier("ic_contact_profile", "drawable", this.packageName))
        } else {
            binding.ivContactDetailProfile.setImageResource(this.resources.getIdentifier(photoName, "drawable", this.packageName))
        }

        // Toolbar
        val toolbar = binding.toolbarContact
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setTitle(data!!.name)
        supportActionBar?.setTitle(name)
        // 전화 앱 실행
        binding.tvContactDetailPhonenum.setOnClickListener {
            val dial = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${phoneNumber!!.replace("-", "")}"))
            startActivity(dial)
        }
    }

    // 툴바에 삭제 버튼 추가
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