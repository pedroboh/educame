package com.application.app.modules.cadastroone.data.model

import com.google.gson.annotations.SerializedName

data class AlunoCadastrado(
    @SerializedName("id") val id :String,
    @SerializedName("email") val email :String,
    @SerializedName("senha") val senha :String)
