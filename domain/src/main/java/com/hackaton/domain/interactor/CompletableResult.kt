package com.hackaton.domain.interactor

sealed class CompletableResult {
    class Success : CompletableResult()
    class Exception(val throwable: Throwable) : CompletableResult()

    fun perform(onSuccess: () -> Unit, onError: (Throwable) -> Unit) {
        when (this) {
            is Success -> onSuccess()
            is Exception -> onError(this.throwable)
        }
    }
}
