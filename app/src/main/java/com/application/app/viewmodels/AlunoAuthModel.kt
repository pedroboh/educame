package com.application.app.viewmodels


import com.application.app.viewmodels.AlunoLoginModel
import com.squareup.moshi.Json

data class AlunoAuthModel(
    @field:Json(name = "registerViewModel") val registerViewModel : AlunoLoginModel,
    @field:Json(name = "token") val token : String
)

