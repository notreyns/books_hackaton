package com.hackaton.newbooks.ui.catalog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hackaton.domain.interactor.GetBooks
import com.hackaton.domain.model.Book
import com.hackaton.newbooks.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    private val getBooks: GetBooks
) : BaseViewModel() {

    val items = MutableLiveData<Collection<Book>>()

    override fun onCreate() {
        super.onCreate()
        getBooks()
    }

    private fun getBooks() {
        getBooks.execute(viewModelScope) { result ->
            result.perform({
                           items.value = it
            }, {

            })
        }
    }
}
