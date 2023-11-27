package com.example.shop_web.service.order;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.Order;
import com.example.shop_web.domain.dto.OrderDetailResDTO;
import com.example.shop_web.domain.dto.OrderResDTO;
import com.example.shop_web.domain.enumaration.EStatus;
import com.example.shop_web.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IOrderService extends IGeneralService<Order,Long> {

    public List<OrderResDTO> findAllOrderByStatus(EStatus status);
    OrderResDTO findOrderResDTOByOrderId( Long orderId );


}
