package com.app.clase11.ui.productDetail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.app.clase11.repository.ProductRepository

class ProductDetailViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository

    init {
        repository = ProductRepository()
    }

    fun getProduct(id: Long){
        val products = repository.getProducts()
    }
}