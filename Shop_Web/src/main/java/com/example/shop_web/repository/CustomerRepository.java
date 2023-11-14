package com.example.shop_web.repository;


import com.example.shop_web.domain.Cart;
import com.example.shop_web.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
