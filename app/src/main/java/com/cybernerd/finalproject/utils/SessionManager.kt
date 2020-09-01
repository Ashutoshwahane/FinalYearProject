package com.cybernerd.finalproject.utils

import android.content.Context
import android.content.SharedPreferences
import com.cybernerd.finalproject.R

class SessionManager (context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_TOKEN = "user_token"
        const val USER_NAME = "user_name"
        const val ROLE = "role"
    }


    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }


    fun fetchAuthToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }

    fun saveUserName(username : String){
        val name = prefs.edit()
        name.putString(USER_NAME, username)
        name.apply()
    }

    fun getUserName(): String?{
        return prefs.getString(USER_NAME, null)
    }

    fun saveRole(role : String){
        val name = prefs.edit()
        name.putString(ROLE, role)
        name.apply()
    }

    fun getRole(): String?{
        return prefs.getString(ROLE, null)
    }
}