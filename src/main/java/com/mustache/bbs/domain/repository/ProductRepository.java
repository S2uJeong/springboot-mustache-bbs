package com.mustache.bbs.domain.repository;

import com.mustache.bbs.domain.dto.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
