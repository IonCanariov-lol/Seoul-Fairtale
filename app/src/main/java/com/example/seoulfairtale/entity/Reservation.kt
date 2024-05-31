package com.example.seoulfairtale

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservations")
data class Reservation(
    val name: String?,
    val phone: String,
    val date: String,
    val time: String,
    val tableNumber: Int,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
)
