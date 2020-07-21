package com.mg.imagegallery.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comment(
    @PrimaryKey(autoGenerate = true)
    val commentId: Int? = null,
    val imageId: String,
    val commentText: String,
    val commentDateTime: String
)
