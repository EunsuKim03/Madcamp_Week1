package com.example.madcamp_week1.db.reservationRoom

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.example.madcamp_week1.db.contactRoom.ContactEntity
import com.example.madcamp_week1.db.restaurantRoom.RestaurantEntity
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun listToJson(value: List<ContactEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<ContactEntity>::class.java).toList()
}

@Entity(tableName = "table_reservation_")
data class ReservationEntity(

    @Embedded val restaurant: RestaurantEntity?,
    val friends: List<ContactEntity>?,
    @ColumnInfo("date") val date: String
) {
    @PrimaryKey(autoGenerate = true) var rsid: Int = 0
}

