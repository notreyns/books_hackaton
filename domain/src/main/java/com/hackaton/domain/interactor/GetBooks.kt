package com.hackaton.domain.interactor

import com.hackaton.domain.model.Book
import com.hackaton.domain.repository.catalog.CatalogRepository
import javax.inject.Inject

class GetBooks @Inject constructor(private val repository: CatalogRepository) :
    UseCase<Collection<Book>, Void>() {
    override suspend fun doOnBackground(params: Void?): Result<Collection<Book>> {
        return repository.getBooks()
    }
}