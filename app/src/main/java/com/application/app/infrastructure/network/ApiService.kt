package com.lastcode.educame.infrastructure.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*


//TODO Troque a url abaixo pela url da a api que voce publicou
private const val BASE_URL =
//    "http://ip172-18-0-36-cc7sndld48eg00dtc9v0-8080.direct.labs.play-with-docker.com/"
    "https://educaappwebapi-jgh3opyuea-rj.a.run.app/"
//singleton
object RetrofitHelper {

    fun getInstance(): Retrofit {
        val moshi = Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .add(KotlinJsonAdapterFactory())
            .build()


        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))

            .baseUrl(BASE_URL)
            .build()

        return retrofit
    }
}