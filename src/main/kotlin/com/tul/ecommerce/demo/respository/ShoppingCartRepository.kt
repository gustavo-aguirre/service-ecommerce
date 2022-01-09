package com.tul.ecommerce.demo.repository

import com.tul.ecommerce.demo.model.ShoppingCart
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ShoppingCartRepository : JpaRepository<ShoppingCart, UUID>