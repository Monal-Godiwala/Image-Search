package com.mg.imagegallery.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CommentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment: Comment)

    @Query("SELECT * FROM Comment WHERE imageId == :imageId ORDER BY commentId DESC")
    fun getCommentByImage(imageId: String): List<Comment>

}