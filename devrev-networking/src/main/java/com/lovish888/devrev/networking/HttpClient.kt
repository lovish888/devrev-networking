package com.lovish888.devrev.networking

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object HttpClient {

    @Throws(Exception::class)
    suspend fun get(url: String): String {
        return withContext(Dispatchers.IO) {
            val urlConnection = URL(url).openConnection() as HttpURLConnection
            try {
                urlConnection.requestMethod = "GET"
                urlConnection.connect()
                if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader(InputStreamReader(urlConnection.inputStream)).use {
                        it.readText()
                    }
                } else {
                    throw Exception("HTTP error code: ${urlConnection.responseCode}")
                }
            } finally {
                urlConnection.disconnect()
            }
        }
    }

    @Throws(Exception::class)
    suspend fun post(url: String, jsonBody: String): String {
        return withContext(Dispatchers.IO) {
            val urlConnection = URL(url).openConnection() as HttpURLConnection
            try {
                urlConnection.requestMethod = "POST"
                urlConnection.doOutput = true
                urlConnection.setRequestProperty("Content-Type", "application/json")
                urlConnection.outputStream.use {
                    it.write(jsonBody.toByteArray())
                }
                urlConnection.connect()
                if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader(InputStreamReader(urlConnection.inputStream)).use {
                        it.readText()
                    }
                } else {
                    throw Exception("HTTP error code: ${urlConnection.responseCode}")
                }
            } finally {
                urlConnection.disconnect()
            }
        }
    }

    @Throws(Exception::class)
    suspend fun put(url: String, jsonBody: String): String {
        return withContext(Dispatchers.IO) {
            val urlConnection = URL(url).openConnection() as HttpURLConnection
            try {
                urlConnection.requestMethod = "PUT"
                urlConnection.doOutput = true
                urlConnection.setRequestProperty("Content-Type", "application/json")
                urlConnection.outputStream.use {
                    it.write(jsonBody.toByteArray())
                }
                urlConnection.connect()
                if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader(InputStreamReader(urlConnection.inputStream)).use {
                        it.readText()
                    }
                } else {
                    throw Exception("HTTP error code: ${urlConnection.responseCode}")
                }
            } finally {
                urlConnection.disconnect()
            }
        }
    }

    @Throws(Exception::class)
    suspend fun delete(url: String): String {
        return withContext(Dispatchers.IO) {
            val urlConnection = URL(url).openConnection() as HttpURLConnection
            try {
                urlConnection.requestMethod = "DELETE"
                urlConnection.connect()
                if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader(InputStreamReader(urlConnection.inputStream)).use {
                        it.readText()
                    }
                } else {
                    throw Exception("HTTP error code: ${urlConnection.responseCode}")
                }
            } finally {
                urlConnection.disconnect()
            }
        }
    }

    @Throws(Exception::class)
    suspend fun download(url: String): ByteArray {
        return withContext(Dispatchers.IO) {
            val urlConnection = URL(url).openConnection() as HttpURLConnection
            try {
                urlConnection.requestMethod = "GET"
                urlConnection.connect()
                if (urlConnection.responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedInputStream(urlConnection.inputStream).use {
                        it.readBytes()
                    }
                } else {
                    throw Exception("HTTP error code: ${urlConnection.responseCode}")
                }
            } finally {
                urlConnection.disconnect()
            }
        }
    }
}
