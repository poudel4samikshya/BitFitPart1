package com.example.bitfitpart1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_table")
data class ActivityEntity(
    @ColumnInfo(name = "food") val food: String?,
    @ColumnInfo(name = "calories") val calories: String?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)