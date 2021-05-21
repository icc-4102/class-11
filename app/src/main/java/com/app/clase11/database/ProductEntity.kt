package com.app.clase11.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "productTable")
data class ProductEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Long,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "price")  var price: Double,
    @ColumnInfo(name = "description") var description: String,
    @ColumnInfo(name = "category") var category: String,
    @ColumnInfo(name = "image") var image: String,
)