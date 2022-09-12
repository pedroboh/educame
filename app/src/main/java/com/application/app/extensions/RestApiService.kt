package com.application.app.extensions

import com.application.app.modules.cadastroone.data.model.AlunoCadastrado
import com.application.app.modules.cadastroone.data.model.AlunoCadastro

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {
    fun addAluno(userData: AlunoCadastro, onResult: (AlunoCadastro?) -> Unit){
        val retrofit = ServiceBuilder.buildService(RetrofitService::class.java)
        retrofit.addAluno(userData).enqueue(
            object : Callback<AlunoCadastro> {
                override fun onFailure(call: Call<AlunoCadastro>, t: Throwable) {
                    onResult(null)
                }
                override fun onResponse( call: Call<AlunoCadastro>, response: Response<AlunoCadastro>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}
