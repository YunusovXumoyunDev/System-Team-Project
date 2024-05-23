package com.example.olim_prototip.data.storage.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LocalStorage(private val context: Context) {
    private val pref = context.getSharedPreferences("my_app_local_storage", Context.MODE_PRIVATE)
    fun saveString(key: String, value: String) {
        pref.edit().apply {
            putString(key, value)
            apply()
        }
    }

    fun saveBoolean(key: String, value: Boolean) {
        pref.edit().apply {
            putBoolean(key, value)
            apply()
        }
    }


    fun getString(key: String): String {
        return pref.getString(key, "") ?: ""
    }

    fun getBoolean(key: String): Boolean {
        return pref.getBoolean(key, false)
    }

    fun saveDoneList(list: ArrayList<Int>) {
        val gsonString = Gson().toJson(list)
        pref.edit().apply {
            putString("Done items", gsonString)
            apply()
        }
    }

    fun getDoneList(): List<Int> {
        val gsonString = pref.getString("Done items", "")
        return if (!gsonString.isNullOrBlank()) {
            val ls = Gson().fromJson<ArrayList<Int>>(gsonString,
                object : TypeToken<ArrayList<Int>>() {}.type)
            ls
        } else emptyList()
    }
}