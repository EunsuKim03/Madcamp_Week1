package com.example.madcamp_week1.db.contactRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_contact_")
data class ContactEntity(
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo_name") val photoName: String,
    @ColumnInfo(name = "phone_number") val phoneNumber: String
) {
    @PrimaryKey(autoGenerate = true) var cid: Int = 0
}