package com.lastcode.educame.infrastructure.network

import com.application.app.viewmodels.AlunoAuthModel
import com.application.app.viewmodels.AlunoCadastroModel
import com.application.app.viewmodels.AlunoModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AlunoApi {

    @GET("api/Alunos")
    suspend fun getAlunos(): List<AlunoModel>

    @POST("api/Alunos/register")
    suspend fun gravarAluno(@Body alunoModel: AlunoCadastroModel) : AlunoAuthModel
}