package com.application.app.modules.cadastroone.data.model

import com.google.gson.annotations.SerializedName

data class AlunoCadastro (
    @SerializedName("id") val id :String? = null,
    @SerializedName("email") val email :String,
    @SerializedName("senha") val senha :String

        )
