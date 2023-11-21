package com.example.shop_web.repository;

import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.ProductResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

    @Query("SELECT NEW com.example.shop_web.domain.dto.ProductResDTO ( " +
            "pro.id, " +
            "pro.productName, " +
            "pro.branch, " +
            "pro.quantity ," +
            "pro.price " +
            ") " +
            "FROM Product AS pro"
    )
    List<ProductResDTO> findAllProductResDTO();
   ;



}
