package com.tul.ecommerce.demo.request

import com.tul.ecommerce.demo.model.Product
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class ShoppingCartRequest(
    val idShoppingCart: UUID?,
    @field:Valid @field:NotNull val product: Product)