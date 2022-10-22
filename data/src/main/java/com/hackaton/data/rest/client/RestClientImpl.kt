package com.hackaton.data.rest.client

import com.hackaton.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import com.hackaton.data.rest.api.AuthApi
import com.hackaton.data.rest.utils.ResultCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RestClientImpl : RestClient {

    private val retrofit: Retrofit

    companion object {
        private const val DEFAULT_TIME_IN_SECOND: Long = 60
    }

    private val httpClient =
        OkHttpClient.Builder()
            .readTimeout(DEFAULT_TIME_IN_SECOND, TimeUnit.SECONDS)
            .connectTimeout(DEFAULT_TIME_IN_SECOND, TimeUnit.SECONDS)
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

    init {
        this.retrofit = Retrofit.Builder()
            .baseUrl("https://icons8.ru/")
            .addCallAdapterFactory(ResultCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()
    }

    override fun authApi(): AuthApi = retrofit.create(AuthApi::class.java)

}