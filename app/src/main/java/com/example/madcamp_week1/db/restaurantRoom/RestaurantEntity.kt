package com.example.madcamp_week1.db.restaurantRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_restaurant_")
data class RestaurantEntity(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo_name") val photoName: String,
    @ColumnInfo(name = "phone_number") val phoneNumber: String,
    @ColumnInfo(name = "address") val address: String
) {
    @PrimaryKey(autoGenerate = true) var rtid:Int = 0
}