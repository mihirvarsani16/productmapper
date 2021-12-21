package com.productmapper.productmapper.repository;

import com.productmapper.productmapper.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Product findById(int id);

}
