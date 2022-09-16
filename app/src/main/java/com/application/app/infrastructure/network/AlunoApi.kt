package com.lastcode.educame.infrastructure.network

import com.application.app.dto.*
import retrofit2.http.*

interface AlunoApi {

    @GET("api/Alunos")
    suspend fun getAlunos(): List<AlunoModel>

    @POST("api/Alunos/register")
    suspend fun gravarAluno(@Body alunoModel: AlunoCadastroModel) : AlunoAuthModel

    @POST("api/Alunos/authorize")
    suspend fun loginAluno(@Body alunoModel: AlunoCadastroModel) : AlunoAuthModel

    @GET("api/Alunos/{id}/agenda")
    suspend fun getAgenda(@Header("Authorization") token: String?, @Path("id") alunoId : String) : AgendaAlunoModel

    @PUT("api/Alunos/{id}/agendarLive")
    suspend fun agendarLive(@Header("Authorization") token: String?, @Path("id") alunoId: String?, @Body live : LiveMarcarModel) : LiveMarcarRetornoModel
}