package com.example.madcamp_week1.db.contactRoom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ContactDao {
    @Query("SELECT * FROM table_contact_")
    suspend fun getAll(): List<ContactEntity>

    @Query("SELECT * FROM table_contact_ WHERE cid IN (:contactIds)")
    suspend fun loadAllByIds(contactIds: IntArray): List<ContactEntity>

    @Query("SELECT * FROM table_contact_ WHERE cid = :cid")
    suspend fun getById(cid: Int): ContactEntity

    // replace if conflicts
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: ContactEntity)

    @Delete
    suspend fun delete(contact: ContactEntity)
}