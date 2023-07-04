package com.example.madcamp_week1.ui.contact

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

        var nameOn = false
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

        phone.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                phoneOn = false
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                phoneVar = phone.text.toString()
                phoneOn = true

                // 여기서 done 처리 할까 그냥
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

        // 이름과 번호가 모두 입력 -> Done 버튼이 활성화 (이거 뭔가 이상함, 내가 원한 대로 작동 하는게 아닌 듯)
        if (nameOn && phoneOn) {
            done.setBackgroundColor(Color.parseColor("#6D7EFD"))
            // Done button listener
            done.setOnClickListener {
//                TODO()
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
                Glide.with(this)
                    .load(uri)
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