package com.hackaton.data.cache.pref

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenSharedPreferences @Inject constructor(@ApplicationContext context: Context) {
    companion object {
        const val PREF_NAME = "pro.breez.intersport.tokens"

        const val TOKEN_NAME = "pro.breez.intersport.auth.token"
    }

    private val pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var token: String?
        get() = pref.getString(TOKEN_NAME, null)
        set(value) {
            pref.edit().putString(TOKEN_NAME, value).apply()
        }
}