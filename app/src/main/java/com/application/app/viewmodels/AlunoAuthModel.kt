package com.lastcode.educame.viewmodels


import com.squareup.moshi.Json

data class AlunoAuthModel(
    @field:Json(name = "registerViewModel") val registerViewModel : AlunoLoginModel,
    @field:Json(name = "token") val token : String
)

