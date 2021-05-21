package com.app.clase11.networking

import com.app.clase11.model.ProductModel
import retrofit2.Call
import retrofit2.http.GET

interface ProductsRemoteRepository {
    @GET("products")
    fun getProducts(): Call<List<ProductModel>>
}