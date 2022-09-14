package com.application.app.dto

import com.squareup.moshi.Json

data class ProfessoresPorMateriasModel(
    @field:Json(name = "id") val id : String,
    @field:Json(name = "nome") val nome: String?,
    @field:Json(name = "professores") val professores: List<ProfessorModel>

)
