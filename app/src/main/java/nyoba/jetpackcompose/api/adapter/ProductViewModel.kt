package nyoba.jetpackcompose.api.adapter

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import nyoba.jetpackcompose.api.ApiClient
import nyoba.jetpackcompose.api.model.Product
import nyoba.jetpackcompose.api.model.ProductResponse
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class ProductViewModel: ViewModel() {
    var products = mutableStateOf<List<Product>>(emptyList())
        private set

    var isLoading = mutableStateOf(false)
        private set

    var errorMassage = mutableStateOf("")
        private set

    init {
        fetchProduct()
    }

    private fun fetchProduct(){
        isLoading.value = true

        ApiClient.productService.getProduct().enqueue(object : Callback<ProductResponse>{
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ){
                isLoading.value = false
                if (response.isSuccessful){
                    products.value = response.body()?.products ?: emptyList()
                }else{
                    errorMassage.value = "Error ${response.message()}"
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                isLoading.value = false
                errorMassage.value = "Failure ${t.message}"
            }
        })
    }

}