package com.hackaton.data.rest.api

import com.hackaton.domain.model.ReservedItem
import retrofit2.http.GET
import retrofit2.http.Header
import com.hackaton.domain.interactor.Result
import com.hackaton.domain.model.Book

interface AuthApi {

    @GET("api/v1/reserved-list")
    fun getReserved(@Header("Authorization") token: String): Result<Collection<ReservedItem>>

    @GET("api/v1/items")
    fun getBooks(@Header("Authorization") token: String): Result<Collection<Book>>

}