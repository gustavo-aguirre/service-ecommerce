package com.tul.ecommerce.demo.repository

import com.tul.ecommerce.demo.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<Product, UUID>