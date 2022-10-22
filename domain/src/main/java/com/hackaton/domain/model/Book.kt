package com.hackaton.domain.model

data class Book(
    val id : Int,
    val author: String,
    val title: String,
    val count: Int,
    val description: String,
    val image: String,
    val category: String,
    val publisher: String,
    val reserved_c: Int,
    val duration: Int,
)