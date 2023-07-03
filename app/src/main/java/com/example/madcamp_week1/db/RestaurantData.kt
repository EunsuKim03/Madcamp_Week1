package com.example.madcamp_week1.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantData(val rid: Int, val name: String, val photoName: String, val resPhone: String, val address: String) : Parcelable
