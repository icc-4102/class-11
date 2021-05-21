package com.app.clase11.ui.cart

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.app.clase11.repository.ProductRepository

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository

    init {
        repository = ProductRepository()
    }

    fun getProducts(){
        val products = repository.getCartProducts()
    }

    fun deleteProduct(){}
}