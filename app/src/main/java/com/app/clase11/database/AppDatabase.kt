package com.app.clase11.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class,CartEntity::class], version =1 , exportSchema = false)
abstract class AppDatabase: RoomDatabase(){
    abstract fun productDao(): ProductDao

    abstract fun cartDao(): CartDao
}