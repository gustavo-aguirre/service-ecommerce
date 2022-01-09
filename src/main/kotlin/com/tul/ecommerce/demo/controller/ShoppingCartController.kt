package com.tul.ecommerce.demo.controller

import  com.tul.ecommerce.demo.model.Product
import  com.tul.ecommerce.demo.model.ShoppingCart
import  com.tul.ecommerce.demo.request.ShoppingCartRequest
import  com.tul.ecommerce.demo.response.CheckoutResponse
import com.tul.ecommerce.demo.exception.HttpException
import  com.tul.ecommerce.demo.service.ShoppingCartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/carts-shopps")
class ShoppingCartController(@Autowired private val service: ShoppingCartService) : HttpException() {

    @DeleteMapping("/{id}/{idProduct}")
    fun deleteProductToCart(
        @PathVariable id: UUID,
        @PathVariable idProduct: UUID
    ): ShoppingCart = service.deleteProductToCart(id, idProduct)

    @GetMapping("/{id}/checkout")
    fun checkout(
        @PathVariable id: UUID
    ): CheckoutResponse = service.checkout(id)
    @GetMapping("/{id}")
    fun getProductsByCart(
        @PathVariable id: UUID
    ): MutableList<Product> = service.getProductsByCart(id)

    @PostMapping
    fun addProductToCart(
        @Validated @RequestBody shoppingCartRequest: ShoppingCartRequest
    ): ShoppingCart = service.addProductToCart(shoppingCartRequest)

    @PutMapping("/{id}")
    fun updateProductToCart(
        @PathVariable id: UUID,
        @Valid @RequestBody product: Product
    ): ShoppingCart = service.updateProductToCart(id, product)



}
