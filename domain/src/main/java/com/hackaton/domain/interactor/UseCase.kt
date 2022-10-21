package com.hackaton.domain.interactor

import kotlinx.coroutines.*
import com.hackaton.domain.exception.ConnectionLostException

abstract class UseCase<T, Params> {
    abstract suspend fun doOnBackground(params: Params?): Result<T>

    private var job: Job?= null

    fun execute(scope: CoroutineScope, params: Params? = null, onResult: (Result<T>) -> Unit) {
        if(job != null) return

        job = scope.launch(Dispatchers.Main) {
            try {
                val deferred = async(Dispatchers.IO) {
                    try {
                        val result = doOnBackground(params)
                        if (result is Result.Exception && result.throwable is ConnectionLostException && scope.isActive) {
                           execute(scope, params, onResult)
                        }
                        result
                    } catch (e:Throwable) {
                        Result.Exception(e)
                    }
                }

                returnResult(onResult, deferred.await())
            } catch (t:Throwable) {
                t.printStackTrace()
                returnResult(onResult, Result.Exception(t))
            }
        }
    }

    private fun returnResult(onResult: (Result<T>) -> Unit, result: Result<T>) {
        onResult(result)
    }
}