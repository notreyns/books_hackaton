package com.hackaton.data.repository

import com.hackaton.data.auth.AuthWrapper
import com.hackaton.data.rest.client.RestClient
import com.hackaton.domain.interactor.Result
import com.hackaton.domain.model.Book
import com.hackaton.domain.model.ReservedItem
import com.hackaton.domain.repository.catalog.CatalogRepository
import javax.inject.Inject

class CatalogRepositoryImpl @Inject constructor(
    private val authWrapper: AuthWrapper,
    private val restClient: RestClient,
) : CatalogRepository {
    override fun getReservedList(): Result<Collection<ReservedItem>> {
        return authWrapper.wrap { token ->
            restClient.authApi().getReserved(token).map {
                it
            }
        }
    }

    override fun getBooks(): Result<Collection<Book>> {
        return authWrapper.wrap { token ->
            restClient.authApi().getBooks(token).map {
                it
            }
        }
    }
}