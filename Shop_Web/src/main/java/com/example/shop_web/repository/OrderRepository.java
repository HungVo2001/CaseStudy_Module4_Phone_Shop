package com.example.shop_web.repository;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.Order;
import com.example.shop_web.domain.dto.OrderResDTO;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.domain.enumaration.EStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("SELECT NEW com.example.shop_web.domain.dto.OrderResDTO ( " +
            "od.id, " +
            "od.user, " +
            "od.orderDate, " +
            "od.totalAmount, " +
            "od.shippingCode, " +
            "od.receiverName, " +
            "od.email, " +
            "od.phone, " +
            "od.locationRegion " +
            ") " +
            "FROM Order AS od WHERE od.status = :status"
    )
    List<OrderResDTO> findAllOrderResDTO(@Param("status") EStatus status );
    ;
    @Query("SELECT NEW com.example.shop_web.domain.dto.OrderResDTO ( " +
            "od.id, " +
            "od.user, " +
            "od.orderDate, " +
            "od.totalAmount, " +
            "od.shippingCode, " +
            "od.receiverName, " +
            "od.email, " +
            "od.phone, " +
            "od.locationRegion " +
            ") " +
            "FROM Order AS od WHERE od.id = :orderId"
    )
    OrderResDTO findOrderResDTOByOrderId(@Param("orderId") Long orderId );
    ;
    @Query("SELECT NEW com.example.shop_web.domain.dto.OrderResDTO ( " +
            "od.id, " +
            "od.user, " +
            "od.orderDate, " +
            "od.totalAmount, " +
            "od.shippingCode, " +
            "od.receiverName, " +
            "od.email, " +
            "od.phone, " +
            "od.locationRegion " +
            ") " +
            "FROM Order AS od WHERE od.status = :status and od.user.id =:userId"
    )
    List<OrderResDTO> findAllOrderResDTOByUserAndStatus(@Param("status") EStatus status, @Param("userId")Long userId );
    ;
}
