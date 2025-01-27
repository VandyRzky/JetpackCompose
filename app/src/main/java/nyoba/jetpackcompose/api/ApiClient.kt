package nyoba.jetpackcompose.api

import nyoba.jetpackcompose.api.services.ProducService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiClient {
    private const val BASE_URL = "https://dummyjson.com/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val productService by lazy{
        retrofit.create(ProducService::class.java)
    }
}