package com.example.friends.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> Gson.fromJson(json: String) : T{
    return fromJson(json, object : TypeToken<T>() {}.type) as T
}



