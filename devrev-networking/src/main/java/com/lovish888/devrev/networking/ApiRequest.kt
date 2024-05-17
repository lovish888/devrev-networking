package com.lovish888.devrev.networking

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object ApiRequest {

    inline fun <reified T> get(
        url: String,
        noinline onSuccess: (T) -> Unit,
        noinline onFailure: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = HttpClient.get(url)
                val result = JsonUtils.fromJson(response, T::class.java)
                CoroutineScope(Dispatchers.Main).launch {
                    onSuccess(result)
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    onFailure(e)
                }
            }
        }
    }

    inline fun <reified T> post(
        url: String,
        body: Any,
        noinline onSuccess: (T) -> Unit,
        noinline onFailure: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val jsonBody = JsonUtils.toJson(body)
                val response = HttpClient.post(url, jsonBody)
                val result = JsonUtils.fromJson(response, T::class.java)
                CoroutineScope(Dispatchers.Main).launch {
                    onSuccess(result)
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    onFailure(e)
                }
            }
        }
    }

    inline fun <reified T> put(
        url: String,
        body: Any,
        noinline onSuccess: (T) -> Unit,
        noinline onFailure: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val jsonBody = JsonUtils.toJson(body)
                val response = HttpClient.put(url, jsonBody)
                val result = JsonUtils.fromJson(response, T::class.java)
                CoroutineScope(Dispatchers.Main).launch {
                    onSuccess(result)
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    onFailure(e)
                }
            }
        }
    }

    inline fun <reified T> delete(
        url: String,
        noinline onSuccess: (T) -> Unit,
        noinline onFailure: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = HttpClient.delete(url)
                val result = JsonUtils.fromJson(response, T::class.java)
                CoroutineScope(Dispatchers.Main).launch {
                    onSuccess(result)
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    onFailure(e)
                }
            }
        }
    }

    fun downloadImage(
        url: String,
        onSuccess: (ByteArray) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val imageData = HttpClient.download(url)
                CoroutineScope(Dispatchers.Main).launch {
                    onSuccess(imageData)
                }
            } catch (e: Exception) {
                CoroutineScope(Dispatchers.Main).launch {
                    onFailure(e)
                }
            }
        }
    }
}
