package com.lovish888.devrev.networking

interface ApiCallback<T> {
    fun onSuccess(result: T)
    fun onFailure(error: Throwable)
}