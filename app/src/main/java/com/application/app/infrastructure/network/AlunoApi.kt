package com.lastcode.educame.infrastructure.network

import com.lastcode.educame.viewmodels.AlunoAuthModel
import com.lastcode.educame.viewmodels.AlunoCadastroModel
import com.lastcode.educame.viewmodels.AlunoModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AlunoApi {

    @GET("api/Alunos")
    suspend fun getAlunos(): List<AlunoModel>

    @POST("api/Alunos/register")
    suspend fun gravarAluno(@Body alunoModel: AlunoCadastroModel) : AlunoAuthModel
}