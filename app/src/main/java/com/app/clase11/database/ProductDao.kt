package com.app.clase11.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertProduct(product: ProductEntity)

    @Query("SELECT * FROM productTable")
     fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM productTable WHERE id = :id")
     fun getProduct(id: Long): ProductEntity

}