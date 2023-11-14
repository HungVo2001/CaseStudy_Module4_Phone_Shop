package com.example.shop_web.repository;


import com.example.shop_web.domain.Cart;
import com.example.shop_web.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
