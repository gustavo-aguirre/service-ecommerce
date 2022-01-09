package com.tul.ecommerce.demo.service

import com.tul.ecommerce.demo.model.Product
import com.tul.ecommerce.demo.model.ShoppingCart
import com.tul.ecommerce.demo.request.ShoppingCartRequest
import com.tul.ecommerce.demo.response.CheckoutResponse
import java.util.*

interface ShoppingCartService {

    fun getProductsByCart(id: UUID): MutableList<Product>

    fun addProductToCart(shoppingCartRequest: ShoppingCartRequest): ShoppingCart

    fun updateProductToCart(id: UUID, product: Product): ShoppingCart

    fun deleteProductToCart(id: UUID, idProduct: UUID): ShoppingCart

    fun checkout(id: UUID): CheckoutResponse

}
