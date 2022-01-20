package com.uygar.eshop.persistence.repositories

import com.uygar.eshop.persistence.entities.Product
import com.uygar.eshop.persistence.entities.User
import org.springframework.data.repository.CrudRepository

interface ProductJpaRepository: CrudRepository<Product, Long>, ProductRepository