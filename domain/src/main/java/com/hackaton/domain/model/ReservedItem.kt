package com.hackaton.domain.model

data class ReservedItem(
    val id: Int,
    val book : Book,
    val date_from: String,
    val date_to : String,
    var status: ReserveStatus
)