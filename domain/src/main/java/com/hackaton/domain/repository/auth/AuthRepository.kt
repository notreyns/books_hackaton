package com.hackaton.domain.repository.auth

import com.hackaton.domain.interactor.CompletableResult

interface AuthRepository {
    fun login() : CompletableResult
}