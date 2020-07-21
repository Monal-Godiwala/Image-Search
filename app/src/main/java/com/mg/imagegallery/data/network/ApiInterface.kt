package com.mg.imagegallery.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit


interface ApiInterface {

    //<editor-fold desc="End Point">

    @GET("/3/gallery/search/1.json")
    suspend fun getImages(@Query(value = "q") query: String): Response<ImageResponse>

    //</editor-fold>

    //<editor-fold desc="API Invoke">

    companion object {

        private const val END_POINT = "https://api.imgur.com"
        const val IMAGE_URL = "https://i.imgur.com/"

        private const val HTTP_CLIENT_CONNECT_TIMEOUT = 1
        private const val HTTP_CLIENT_READ_TIMEOUT = 30

        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor,
            headerInterceptor: HeaderInterceptor
        ): ApiInterface {

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor(logging)
                .addInterceptor(networkConnectionInterceptor)
                .addInterceptor(headerInterceptor)
                .connectTimeout(HTTP_CLIENT_CONNECT_TIMEOUT.toLong(), TimeUnit.MINUTES)
                .readTimeout(HTTP_CLIENT_READ_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
                .create(ApiInterface::class.java)

        }
    }

    //</editor-fold>

}