package com.application.app.dto

import com.squareup.moshi.Json
import java.util.*

data class LiveMarcarModel(
    @field:Json(name = "data") val data: Date,
    @field:Json(name = "nome") val nome: String,
    @field:Json(name = "link") val link: String,
    @field:Json(name = "profesor") val professor: ProfessorMarcarLiveModel
)
