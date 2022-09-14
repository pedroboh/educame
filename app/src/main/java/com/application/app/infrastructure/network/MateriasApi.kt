package com.application.app.infrastructure.network

import com.application.app.dto.AlunoModel
import com.application.app.dto.ProfessoresPorMateriasModel
import com.application.app.modules.professores.data.model.ProfessoresRowModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MateriasApi {

    @GET("api/Materias/{materiaId}/professores")
    suspend fun getProfessores(@Header("Authorization") token: String?, @Path("materiaId") materiaId : String): ProfessoresPorMateriasModel
}