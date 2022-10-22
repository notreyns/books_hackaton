package com.hackaton.newbooks.ui.student

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hackaton.domain.interactor.GetReservedList
import com.hackaton.domain.model.Book
import com.hackaton.domain.model.ReserveStatus
import com.hackaton.domain.model.ReservedItem
import com.hackaton.newbooks.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MyBooksViewModel @Inject constructor(
    private val getReservedList: GetReservedList
) : BaseViewModel() {

    val items = MutableLiveData<Collection<ReservedItem>>()

    override fun onCreate() {
        super.onCreate()
        getList()
    }

    private fun getList() {
        val list = listOf<ReservedItem>(
            ReservedItem(
                1,
                Book(
                    1, "Author", "Таинственный остров", 30,
                    "", "", "Фольклор", "", 10, 10
                ),
                "", "24.10.2021", ReserveStatus.RESERVED
            )
        )
        getReservedList.execute(viewModelScope) { result ->
            result.perform({
                items.value = it
            }, {
                items.value = list
            })
        }
    }
}