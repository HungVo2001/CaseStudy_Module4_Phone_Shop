package com.example.shop_web.repository;


import com.example.shop_web.domain.Cart;
import com.example.shop_web.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
