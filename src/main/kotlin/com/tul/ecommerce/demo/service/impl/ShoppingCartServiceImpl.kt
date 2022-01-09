package com.tul.ecommerce.demo.service.impl

import com.tul.ecommerce.demo.model.Product
import com.tul.ecommerce.demo.model.ShoppingCart
import com.tul.ecommerce.demo.enum.State.COMPLETED
import com.tul.ecommerce.demo.repository.ShoppingCartRepository
import com.tul.ecommerce.demo.request.ShoppingCartRequest
import com.tul.ecommerce.demo.response.CheckoutResponse
import com.tul.ecommerce.demo.service.ShoppingCartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class ShoppingCartServiceImpl(@Autowired private val repository: ShoppingCartRepository) : ShoppingCartService {

    @Value("\${value-divider}")
    var discountDivider: Int = 2

    override fun getProductsByCart(id: UUID): MutableList<Product> {
        return repository.findById(id)
            .map(ShoppingCart::products)
            .get()
    }

    override fun addProductToCart(cartShoppDTO: ShoppingCartRequest): ShoppingCart {
        var cartShopp = ShoppingCart(mutableListOf())
        cartShopp.products.add(cartShoppDTO.product)
        return repository.save(cartShopp)
    }

    override fun updateProductToCart(id: UUID, product: Product): ShoppingCart {
        val cartShopp = repository.findById(id).get()
        cartShopp.products.forEach { if (it.id == product.id) it.amount = product.amount }
        return repository.save(cartShopp)
    }

    override fun deleteProductToCart(id: UUID, idProduct: UUID): ShoppingCart {
        val cartShopp = repository.findById(id).get()
        cartShopp.products = cartShopp.products
            .filterNot { product -> product.id == idProduct }.toMutableList()
        return repository.save(cartShopp)
    }

    override fun checkout(id: UUID): CheckoutResponse {
        val cartShopp = repository.findById(id).get()
        val totalWithDiscount = cartShopp.products
            .filter { it.withDiscount }
            .sumOf { product -> (product.price * product.amount) / discountDivider }
        val totalWithoutDiscount = cartShopp.products
            .filterNot { it.withDiscount }
            .sumOf { product -> product.price * product.amount }
        cartShopp.state = COMPLETED
        repository.save(cartShopp)
        return CheckoutResponse(totalWithDiscount + totalWithoutDiscount)
    }

}
