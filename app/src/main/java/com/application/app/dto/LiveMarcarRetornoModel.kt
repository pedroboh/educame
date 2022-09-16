package com.application.app.dto

import com.squareup.moshi.Json
import java.util.*

data class LiveMarcarRetornoModel(
    @field:Json(name="id") val id :String,
    @field:Json(name = "data") val data: Date,
    @field:Json(name = "nome") val nome: String,
    @field:Json(name = "link") val link: String,
    @field:Json(name = "profesor") val professor: ProfessorMarcarLiveModel)
