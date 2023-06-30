package com.example.madcamp_week1.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantData(val name: String, val resPhone: String, val address: String) : Parcelable
