package com.example.testproject.Room.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "courses")
data class Course(
    @PrimaryKey
    val id: Int,
    val title: String,
    val text: String,

    @SerializedName("price")
    val priceString: String,

    @SerializedName("rate")
    val rateString: String,
    val startDate: String,
    val hasLike: Boolean,
    val publishDate: String
) {
    val price: Double
        get() = priceString.replace(" ", "").toDoubleOrNull() ?: 0.0

    val rate: Double
        get() = rateString.toDoubleOrNull() ?: 0.0
}