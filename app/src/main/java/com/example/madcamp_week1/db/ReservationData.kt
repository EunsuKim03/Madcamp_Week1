package com.example.madcamp_week1.db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate
import java.util.Date

@Parcelize
data class ReservationData(val restaurant: RestaurantData, val contacts: ArrayList<ContactData>, val date: String) : Parcelable
