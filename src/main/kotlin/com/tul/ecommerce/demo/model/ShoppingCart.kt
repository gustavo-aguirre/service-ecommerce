package com.tul.ecommerce.demo.model

import com.tul.ecommerce.demo.enum.State
import com.tul.ecommerce.demo.enum.State.PENDING
import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class ShoppingCart(
    @OneToMany var products: MutableList<Product>,
    var state: State = PENDING,
    id: UUID? = null
) : AllocateIdBaseEntity(id)
