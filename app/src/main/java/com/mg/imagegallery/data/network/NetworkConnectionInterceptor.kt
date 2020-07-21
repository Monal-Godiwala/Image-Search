package com.mg.imagegallery.data.network

import android.content.Context
import android.net.ConnectivityManager
import com.mg.imagegallery.R
import com.mg.imagegallery.util.NoNetworkException
import okhttp3.Interceptor
import okhttp3.Response

/** Class to check network connection */
class NetworkConnectionInterceptor(context: Context) : Interceptor {

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isNetworkAvailable()) {
            throw NoNetworkException(applicationContext.getString(R.string.message_no_internet_connection))
        }
        return chain.proceed(chain.request())
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }
}