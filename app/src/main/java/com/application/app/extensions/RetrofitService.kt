package com.application.app.extensions

import com.application.app.modules.cadastroone.data.model.AlunoCadastro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitService {

    //https://localhost:7250/api/Alunos/register/
    @Headers("Content-Type: application/json")
    @POST("Alunos/register")
    fun addAluno(@Body alunoData : AlunoCadastro): Call<AlunoCadastro>

}