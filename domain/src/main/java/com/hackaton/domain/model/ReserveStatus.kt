package com.hackaton.domain.model

enum class ReserveStatus(
    val code: String,
    val message: String,
) {
    RESERVED("RESERVED", "Книга у вас"),
    EXPIRED("EXPIRED", "Бронь истекла"),
    RETURNED("RETURNED", "Возвращено")
}