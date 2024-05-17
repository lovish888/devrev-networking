package com.lovish888.devrev.networking

import com.google.gson.Gson

object JsonUtils {
    private val gson = Gson()

    fun <T> fromJson(json: String, classT: Class<T>): T {
        return gson.fromJson(json, classT)
    }

    fun <T> toJson(obj: T): String {
        return gson.toJson(obj)
    }
}
