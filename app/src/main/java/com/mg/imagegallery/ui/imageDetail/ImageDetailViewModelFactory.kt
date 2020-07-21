package com.mg.imagegallery.ui.imageDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mg.imagegallery.data.database.AppDatabase
import com.mg.imagegallery.data.network.ImageResponse

@Suppress("UNCHECKED_CAST")
class ImageDetailViewModelFactory(
    private val imageDetail: ImageResponse.Data?,
    private val database: AppDatabase
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageDetailViewModel(
            imageDetail,
            database
        ) as T
    }

}