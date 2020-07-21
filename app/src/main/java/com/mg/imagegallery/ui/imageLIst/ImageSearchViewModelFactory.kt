package com.mg.imagegallery.ui.imageLIst

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mg.imagegallery.data.repository.ImageRepository

@Suppress("UNCHECKED_CAST")
class ImageSearchViewModelFactory(private val imageRepository: ImageRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ImageSearchViewModel(imageRepository) as T
    }

}