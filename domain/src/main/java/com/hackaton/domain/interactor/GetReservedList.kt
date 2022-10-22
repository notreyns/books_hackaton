package com.hackaton.domain.interactor

import com.hackaton.domain.model.ReservedItem
import com.hackaton.domain.repository.catalog.CatalogRepository
import javax.inject.Inject

class GetReservedList @Inject constructor(private val repository: CatalogRepository) :
    UseCase<Collection<ReservedItem>, Void>() {
    override suspend fun doOnBackground(params: Void?): Result<Collection<ReservedItem>> {
        return repository.getReservedList()
    }
}