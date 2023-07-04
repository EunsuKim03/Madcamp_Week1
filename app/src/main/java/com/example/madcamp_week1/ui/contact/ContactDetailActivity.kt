package com.example.madcamp_week1.ui.contact

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import android.widget.Toast
import androidx.room.Room
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityContactDetailBinding
import com.example.madcamp_week1.db.ContactData
import com.example.madcamp_week1.db.contactRoom.ContactDatabase
import com.example.madcamp_week1.db.contactRoom.ContactEntity
import com.example.madcamp_week1.ui.gallery.GalleryMapActivity
import kotlinx.coroutines.runBlocking

class ContactDetailActivity : AppCompatActivity() {

    lateinit var db: ContactDatabase
    var cid: Int = -1

    private lateinit var binding : ActivityContactDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        db = Room.databaseBuilder(
            applicationContext,
            ContactDatabase::class.java, "contactDB"
        ).build()

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
        cid = intent.getIntExtra("cid", -1)
        val name = intent.getStringExtra("name")
        val photoName = intent.getStringExtra("photoName")
        val phoneNumber = intent.getStringExtra("phoneNumber")

        binding.tvContactDetailName.text = name
        binding.tvContactDetailPhonenum.text = phoneNumber

        println("\n\n\nhere: $photoName\n\n\n")

        if(photoName == "") {
            binding.ivContactDetailProfile.setImageResource(this.resources.getIdentifier("ic_contact_profile", "drawable", this.packageName))
        } else {
            Glide.with(applicationContext)
                .load(Uri.parse(photoName))
                .error(R.drawable.ic_contact_profile)
                .into(binding.ivContactDetailProfile)
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
                val temp: ContactEntity
                if(cid != -1) {
                    runBlocking { temp = db.contactDao().getById(cid) }
                    runBlocking { db.contactDao().delete(temp) }
                    Toast.makeText(this, "Successfully deleted!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}