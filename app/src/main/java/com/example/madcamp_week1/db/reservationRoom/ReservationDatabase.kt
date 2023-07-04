package com.example.madcamp_week1.db.reservationRoom

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.madcamp_week1.db.contactRoom.ContactDao
import com.example.madcamp_week1.db.contactRoom.ContactEntity

@Database(entities = [ReservationEntity::class, ContactEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class ReservationDatabase : RoomDatabase() {
    abstract fun reservationDao(): ReservationDao
    abstract fun contactDao(): ContactDao
}