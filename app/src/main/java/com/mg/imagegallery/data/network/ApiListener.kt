package com.mg.imagegallery.data.network

interface ApiListener {

    fun onStarted(requestCode: Int)
    fun onSuccess(response: Any, requestCode: Int)
    fun onFailure(message: String, requestCode: Int)

}