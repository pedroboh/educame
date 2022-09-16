package com.application.app.dto


import com.squareup.moshi.Json
import java.util.*

data class AgendaAlunoModel(
    @field:Json(name = "data") val data: Date,
    @field:Json(name = "emailProfessor") val emailProfessor: String,
    @field:Json(name = "nomeProfessor") val nomeProfessor: String,
    @field:Json(name = "nomeLive") val nomeLive: String,
    @field:Json(name = "url") val url: String
)

