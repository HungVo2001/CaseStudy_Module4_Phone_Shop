package com.example.shop_web.repository;


import com.example.shop_web.domain.Bill;
import com.example.shop_web.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {

}
