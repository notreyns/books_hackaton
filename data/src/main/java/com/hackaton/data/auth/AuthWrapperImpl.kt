package com.hackaton.data.auth

import com.hackaton.data.cache.pref.TokenSharedPreferences
import javax.inject.Inject

class AuthWrapperImpl @Inject constructor(
    private val tokenSharedPreferences: TokenSharedPreferences
) : AuthWrapper {
    override fun <T> wrap(onToken: (String) -> T): T {
        val token = tokenSharedPreferences.token

        return onToken(token?:"")
    }
}