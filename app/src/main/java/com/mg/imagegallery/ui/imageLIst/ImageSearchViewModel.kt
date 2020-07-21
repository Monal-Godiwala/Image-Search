package com.mg.imagegallery.ui.imageLIst

import androidx.lifecycle.ViewModel
import com.mg.imagegallery.data.network.ApiListener
import com.mg.imagegallery.data.repository.ImageRepository
import com.mg.imagegallery.util.ApiException
import com.mg.imagegallery.util.Coroutines
import com.mg.imagegallery.util.NoNetworkException
import kotlinx.coroutines.delay


class ImageSearchViewModel(private val imageRepository: ImageRepository) : ViewModel() {

    companion object {
        const val API_SEARCH_IMAGE = 101
    }

    var apiListener: ApiListener? = null

    /** API call for fetching images */
    fun getImages(query: String) {
        apiListener?.onStarted(API_SEARCH_IMAGE)
        Coroutines.main {
            try {
                /** Set debounce time */
                delay(250)
                val imageResponse = imageRepository.getImages(query)
                imageResponse.let {
                    apiListener?.onSuccess(it, API_SEARCH_IMAGE)
                    return@main
                }
            } catch (e: ApiException) {
                apiListener?.onFailure(e.message!!, API_SEARCH_IMAGE)
            } catch (e: NoNetworkException) {
                apiListener?.onFailure(e.message!!, API_SEARCH_IMAGE)
            }
        }

    }

}



