package com.tul.ecommerce.demo.service

import com.tul.ecommerce.demo.model.Product
import java.util.*

interface ProductService {

    fun getProducts(): List<Product>

    fun createProduct(product: Product): Product

    fun updateProduct(id: UUID,product: Product): Product

    fun deleteProduct(id: UUID)

}
