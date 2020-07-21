package com.mg.imagegallery.ui.imageDetail

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mg.imagegallery.data.database.AppDatabase
import com.mg.imagegallery.data.database.Comment
import com.mg.imagegallery.data.network.ApiInterface
import com.mg.imagegallery.data.network.ImageResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


class ImageDetailViewModel(
    val imageDetail: ImageResponse.Data?,
    val database: AppDatabase
) : ViewModel() {

    var commentList = MutableLiveData<List<Comment>>()

    /** Fetch Image URL to display larger image */
    fun getImageUrl(): String {
        return if (imageDetail?.cover != null) {
            "${ApiInterface.IMAGE_URL}${imageDetail.cover}.jpg"
        } else {
            "${imageDetail?.link}"
        }
    }

    /** Insert comment to database */
    fun insertComment(commentText: String) {
        GlobalScope.launch {
            imageDetail?.id?.let { imageId ->

                val comment = Comment(
                    imageId = imageId,
                    commentText = commentText,
                    commentDateTime = getTime()
                )

                database.commentDao().insertComment(comment)
                commentList.postValue(database.commentDao().getCommentByImage(imageId))
            }
        }
    }

    /** Load existing comments from database */
    fun refreshCommentList(imageId: String) {
        GlobalScope.launch {
            commentList.postValue(
                database.commentDao().getCommentByImage(imageId)
            )
        }
    }

    /** Get comment added time */
    @SuppressLint("SimpleDateFormat")
    private fun getTime(): String {
        val formatter = SimpleDateFormat("MMM dd, hh:mm a")
        val now = System.currentTimeMillis()
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = now
        return formatter.format(calendar.time)
    }

}



