package com.example.shop_web.repository;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.OrderDetail;
import com.example.shop_web.domain.dto.OrderDetailResDTO;
import com.example.shop_web.domain.dto.OrderResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query("SELECT NEW com.example.shop_web.domain.dto.OrderDetailResDTO ( " +
            "orDetail.quantity, " +
            "orDetail.totalAmount, " +
            "orDetail.product " +
            ") " +
            "FROM OrderDetail AS orDetail WHERE orDetail.order.id = :orderId"
    )
    List<OrderDetailResDTO> findAllOrderDetailByOrderId(@Param("orderId") Long orderId );
    ;

}
