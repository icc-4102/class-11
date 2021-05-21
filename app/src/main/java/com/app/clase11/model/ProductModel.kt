package com.app.clase11.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    var id: Long,
    var title: String,
    var price: Double,
    var description: String,
    var category: String,
    var image: String
): Parcelable
