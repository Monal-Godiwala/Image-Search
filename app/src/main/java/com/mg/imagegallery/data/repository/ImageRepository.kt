package com.mg.imagegallery.data.repository


import com.mg.imagegallery.data.network.ApiInterface
import com.mg.imagegallery.data.network.ImageResponse
import com.mg.imagegallery.data.network.SafeApiRequest

class ImageRepository(private val apiInterface: ApiInterface) : SafeApiRequest() {

    suspend fun getImages(query: String): ImageResponse =
        apiRequest { apiInterface.getImages(query) }

}