package com.app.clase11.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.app.clase11.repository.ProductRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: ProductRepository

    init {
        repository = ProductRepository()
    }

    fun getProducts(){
        val products = repository.getProducts()
    }
}