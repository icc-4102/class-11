package com.app.clase11.repository

import android.app.Application
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import com.app.clase11.database.AppDatabase
import com.app.clase11.database.CartDao
import com.app.clase11.database.ProductDao
import com.app.clase11.model.ProductEntityMapper
import com.app.clase11.model.ProductModel
import com.app.clase11.networking.ProductsRemoteRepository
import com.app.clase11.networking.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.logging.Handler


class ProductRepository(application: Application) {

    private val service: ProductsRemoteRepository
    private val products = MutableLiveData<List<ProductModel>>()
    private val database: AppDatabase
    private val productDao: ProductDao
    private val cartDao: CartDao
    private val productEntityMapper: ProductEntityMapper
    private val executor: ExecutorService = Executors.newSingleThreadExecutor()


    init {
        service = getRetrofit().create(ProductsRemoteRepository::class.java)
        database = Room.databaseBuilder(application, AppDatabase::class.java, "ecomerce-db").build()
        productDao = database.productDao()
        cartDao = database.cartDao()
        productEntityMapper = ProductEntityMapper()
    }

    fun deleteProductFromCart(id: Long) {
        executor.execute {
            cartDao.deleteProduct(id)
        }
    }

    fun getCartProducts() {
        //Aqui hay que hacer un livedata para rescatar los productos
        executor.execute {
            cartDao.getProducts()
        }
    }

    fun getProduct(id: Long) {
        productDao.getProduct(id)
    }

    fun getProducts(): LiveData<List<ProductModel>> {
        getCacheProducts()
        if (products.value.isNullOrEmpty()) {
            getRemoteProducts()
        }
        productDao.getProducts()
        getCacheProducts()
        return products
    }

    private fun getRemoteProducts() {
        val call = service.getProducts()
        call.enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                val body = response.body()
                if (body != null) {
                    val prod = products.value
                    executor.execute {
                        body.forEach {
                            productDao.insertProduct(productEntityMapper.mapToCached(it))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                println("Fallo la request")
            }
        })
    }

    private fun getCacheProducts() {
        executor.execute {
            products.postValue(
                productDao.getProducts().map { productEntityMapper.mapFromCached(it) })
        }
    }

}