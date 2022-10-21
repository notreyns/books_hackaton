package com.hackaton.data.auth

interface AuthWrapper {
    fun <T> wrap(onToken: (String) -> T): T
}