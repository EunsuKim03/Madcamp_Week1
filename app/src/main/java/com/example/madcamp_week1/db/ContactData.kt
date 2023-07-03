package com.example.madcamp_week1.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//class ContactData (
//    private var name: String? = null,
//    private var phoneNumber: String? = null
//) {
//    fun getName(): String? {
//        return name
//    }
//    fun setName(name: String) {
//        this.name = name
//    }
//    fun getPhoneNumber(): String? {
//        return phoneNumber
//    }
//    fun setPhoneNumber(phoneNumber: String) {
//        this.phoneNumber = phoneNumber
//    }
//}

@Parcelize
data class ContactData(val cid: Int, val name: String, val photoName: String, val phoneNumber: String) : Parcelable