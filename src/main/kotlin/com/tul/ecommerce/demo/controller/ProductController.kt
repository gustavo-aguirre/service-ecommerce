package com.tul.ecommerce.demo.controller

import com.tul.ecommerce.demo.exception.HttpException
import com.tul.ecommerce.demo.model.Product
import com.tul.ecommerce.demo.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
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
@RequestMapping("/products")
class ProductController(@Autowired private val service: ProductService): HttpException() {

    @GetMapping
    fun getProducts(): List<Product> = service.getProducts()

    @PostMapping
    fun createProduct(
        @RequestBody @Valid product: Product
    ): Product = service.createProduct(product)

    @PutMapping("/{id}")
    fun updateProduct(
        @PathVariable id: UUID,
        @RequestBody @Valid product: Product
    ): Product = service.updateProduct(id, product)

    @DeleteMapping("/{id}")
    fun deleteProduct(
        @PathVariable id: UUID
    ): Unit = service.deleteProduct(id)


}
