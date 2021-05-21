package com.app.clase11.database

import androidx.room.*

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: CartEntity )

    @Query("SELECT productTable.title, productTable.price FROM productTable INNER JOIN cartTable ON productTable.id = cartTable.id ")
    fun getProducts(): List<ProductEntity>

    @Query("DELETE FROM cartTable WHERE id = :id")
    fun deleteProduct(id: Long)

}