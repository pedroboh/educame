package com.lastcode.educame.infrastructure.network

import com.application.app.dto.AlunoAuthModel
import com.application.app.dto.AlunoCadastroModel
import com.application.app.dto.AlunoLoginModel
import com.application.app.dto.AlunoModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AlunoApi {

    @GET("api/Alunos")
    suspend fun getAlunos(): List<AlunoModel>

    @POST("api/Alunos/register")
    suspend fun gravarAluno(@Body alunoModel: AlunoCadastroModel) : AlunoAuthModel

    @POST("api/Alunos/authorize")
    suspend fun loginAluno(@Body alunoModel: AlunoCadastroModel) : AlunoAuthModel
}