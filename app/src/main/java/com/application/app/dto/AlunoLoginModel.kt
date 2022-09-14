package com.application.app.dto

data class AlunoLoginModel(
    val id : String? = "",
    val email : String = "",
    val password : String = "",
    val role: String? = ""
)
