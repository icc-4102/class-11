package com.app.clase11.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cartTable")
data class CartEntity(
    @PrimaryKey
    @ColumnInfo(name = "id") var id: Long
)