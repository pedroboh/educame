package com.application.app.infrastructure

import android.content.Context
import android.content.SharedPreferences
import com.application.app.R


class SessionManager(context: Context) {
    private var preferences: SharedPreferences = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object{
        const val USER_TOKEN = "user_token"
    }

    fun saveAuthToken(token: String){
        val editor = preferences.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }


    fun fetchAuthToken():String?{
        return preferences.getString(USER_TOKEN,null)
    }
}