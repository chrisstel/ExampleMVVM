package com.example.examplemvvm.model

import android.content.Context

internal const val  PREF_NAME: String = "UserPref"

class UserSharedPref(
    private val context: Context
) {
    fun save(username: String, email: String) {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        sharedPref.edit().apply {
            putString("username", username)
            putString("email", email)
            apply()
        }
    }

    fun load(): User {
        val sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val username = sharedPref.getString("username", "empty")!!
        val email = sharedPref.getString("email", "empty")!!

        return User(username, email)
    }
}