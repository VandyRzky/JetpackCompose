package nyoba.jetpackcompose.api.services

import nyoba.jetpackcompose.api.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface ProducService {

    @GET("products")
    fun getProduct(): Call<ProductResponse>
}