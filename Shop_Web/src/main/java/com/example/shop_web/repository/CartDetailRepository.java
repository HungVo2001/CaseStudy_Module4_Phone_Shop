package com.example.shop_web.repository;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail,Long> {
}
