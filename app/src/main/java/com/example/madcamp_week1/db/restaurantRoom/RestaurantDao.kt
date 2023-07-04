package com.example.madcamp_week1.db.restaurantRoom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RestaurantDao {
    @Query("SELECT * FROM table_restaurant_")
    suspend fun getAll(): List<RestaurantEntity>

    @Query("SELECT * FROM table_restaurant_ WHERE rtid IN (:restaurantIds)")
    suspend fun loadAllByIds(restaurantIds: IntArray): List<RestaurantEntity>

    @Query("SELECT * FROM table_restaurant_ WHERE rtid = :rtid")
    suspend fun getById(rtid: Int): RestaurantEntity

    // replace if conflicts
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(contact: RestaurantEntity)

    @Delete
    suspend fun delete(contact: RestaurantEntity)
}