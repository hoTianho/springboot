package com.imooc.demo.dao;

import com.imooc.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductDao extends JpaRepository<Product,Long> {
    @Override
    public Optional<Product> findById(Long id);
}
