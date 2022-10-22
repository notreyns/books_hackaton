package com.hackaton.newbooks.di

import com.hackaton.data.auth.AuthWrapper
import com.hackaton.data.repository.CatalogRepositoryImpl
import com.hackaton.data.rest.client.RestClient
import com.hackaton.domain.repository.catalog.CatalogRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class ApplicationModule {

    @Provides
    fun provideCatalogRepository(
        authWrapper: AuthWrapper,
        restClient: RestClient
    ): CatalogRepository {
        return CatalogRepositoryImpl(
            authWrapper,
            restClient
        )
    }
}