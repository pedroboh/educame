package com.application.app.dto

import com.squareup.moshi.Json
import java.util.*

data class ProfessorMarcarLiveModel(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "nome") val nome: String,
    @field:Json(name = "email") val email: String

)
