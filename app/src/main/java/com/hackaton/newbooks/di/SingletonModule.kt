package com.hackaton.newbooks.di

import com.hackaton.data.auth.AuthWrapper
import com.hackaton.data.auth.AuthWrapperImpl
import com.hackaton.data.cache.pref.TokenSharedPreferences
import com.hackaton.data.rest.client.RestClient
import com.hackaton.data.rest.client.RestClientImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {

    @Provides
    fun provideRestClient(): RestClient {
        return RestClientImpl()
    }

    @Provides
    fun provideAuthWrapper(
        tokenSharedPreferences: TokenSharedPreferences
    ): AuthWrapper {
        return AuthWrapperImpl(tokenSharedPreferences)
    }
}