package com.mg.imagegallery.data.network

import okhttp3.Interceptor
import okhttp3.Response

/** Add Header in API */
class HeaderInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request().newBuilder().addHeader("Authorization", "Client-ID 137cda6b5008a7c")
        return chain.proceed(request.build())
    }

}