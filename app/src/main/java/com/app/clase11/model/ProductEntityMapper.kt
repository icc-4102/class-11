package com.app.clase11.model

import com.app.clase11.database.ProductEntity

class ProductEntityMapper : EntityMapper<ProductEntity, ProductModel> {

    override fun mapFromCached(type: ProductEntity): ProductModel {
        return ProductModel(
            type.id,
            type.title,
            type.price,
            type.category,
            type.description,
            type.image,
        )
    }

    override fun mapToCached(type: ProductModel): ProductEntity {
        return ProductEntity(
            type.id,
            type.title,
            type.price,
            type.description,
            type.category,
            type.image
        )
    }
}