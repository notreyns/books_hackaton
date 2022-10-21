package com.hackaton.data.rest.client

import com.hackaton.data.rest.api.AuthApi

interface RestClient {
    fun authApi() : AuthApi
}