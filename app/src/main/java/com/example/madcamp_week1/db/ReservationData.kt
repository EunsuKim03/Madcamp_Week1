package com.example.madcamp_week1.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReservationData(val restaurant: RestaurantData, val contacts: ArrayList<ContactData>) : Parcelable
