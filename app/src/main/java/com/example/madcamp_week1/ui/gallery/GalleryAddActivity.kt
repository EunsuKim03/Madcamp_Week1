package com.example.madcamp_week1.ui.gallery

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.madcamp_week1.R
import com.example.madcamp_week1.databinding.ActivityContactAddBinding
import com.example.madcamp_week1.databinding.ActivityGalleryAddBinding

class GalleryAddActivity : AppCompatActivity() {
    private lateinit var binding : ActivityGalleryAddBinding

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

        var nameOn = false
        var addrOn = false
        var phoneOn = false

        name.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                nameOn = false
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                nameVar = name.text.toString()
                nameOn = true
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        addr.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                addrOn = false
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                addrVar = addr.text.toString()
                addrOn = true
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        phone.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                phoneOn = false
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                phoneVar = phone.text.toString()
                phoneOn = true

                // 여기서 done 처리 할까 그냥
                println("\n\ndone enabled\n\n")
                done.setBackgroundColor(Color.parseColor("#6D7EFD"))
                // Done button listener
                done.setOnClickListener {
    //                TODO()
                }
            }

            override fun afterTextChanged(p0: Editable?) {}

        })

        // Image button listener
        image.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            activityResult.launch(intent)
        }

        // 이름과 주소, 번호가 모두 입력 -> Done 버튼이 활성화 (이상함)
        if (nameOn && addrOn && phoneOn) {
            done.setBackgroundColor(0x6D7EFD)
            // Done button listener
            done.setOnClickListener {
                TODO()
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