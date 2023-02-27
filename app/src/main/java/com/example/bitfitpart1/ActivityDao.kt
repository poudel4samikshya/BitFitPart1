package com.example.bitfitpart1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ActivityDao {
    @Query("SELECT * FROM food_table")
    fun getAll(): Flow<List<ActivityEntity>>

    @Insert
    fun insertAll(foods: List<ActivityEntity>)

    @Insert
    fun insert(food: ActivityEntity)

    @Query("DELETE FROM food_table")
    fun deleteAll()
}