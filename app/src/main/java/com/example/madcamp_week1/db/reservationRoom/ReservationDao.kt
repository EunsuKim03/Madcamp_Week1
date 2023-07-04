package com.example.madcamp_week1.db.reservationRoom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReservationDao {
    @Query("SELECT * FROM table_reservation_")
    suspend fun getAll(): List<ReservationEntity>

    @Query("SELECT * FROM table_reservation_ WHERE rsid IN (:reservationIds)")
    suspend fun loadAllByIds(reservationIds: IntArray): List<ReservationEntity>

    @Query("SELECT * FROM table_reservation_ WHERE rsid = :rsid")
    suspend fun getById(rsid: Int): ReservationEntity

    // replace if conflicts
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(reservation: ReservationEntity)

    @Delete
    suspend fun delete(reservation: ReservationEntity)
}