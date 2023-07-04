package com.example.madcamp_week1.db.contactRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ContactEntity::class], version = 2)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}