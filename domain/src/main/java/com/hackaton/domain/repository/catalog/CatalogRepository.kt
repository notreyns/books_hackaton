package com.hackaton.domain.repository.catalog

import com.hackaton.domain.model.ReservedItem
import com.hackaton.domain.interactor.Result
import com.hackaton.domain.model.Book

interface CatalogRepository {
    fun getReservedList(): Result<Collection<ReservedItem>>
    fun getBooks(): Result<Collection<Book>>
}