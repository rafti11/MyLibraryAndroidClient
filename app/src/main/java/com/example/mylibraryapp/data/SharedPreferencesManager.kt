package com.example.mylibraryapp.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("data", Context.MODE_PRIVATE)

    fun save(key: String, value: String) {

        val save = sharedPreferences.edit()
        save.putString(key, value)
        save.apply()

    }

    fun save(key: String, value: Int) {

        val save = sharedPreferences.edit()
        save.putInt(key, value)
        save.apply()

    }

    fun get(key: String) : String {

        return sharedPreferences.getString(key, "") ?: ""

    }

    fun getInt(key: String) : Int {

        return sharedPreferences.getInt(key, -1)

    }
}