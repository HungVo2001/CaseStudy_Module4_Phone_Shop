package com.example.shop_web.service.orderDetail;

import com.example.shop_web.domain.OrderDetail;
import com.example.shop_web.domain.dto.OrderDetailResDTO;
import com.example.shop_web.service.IGeneralService;

import java.util.List;

public interface IOrderDetailService extends IGeneralService<OrderDetail,Long> {
    public List<OrderDetailResDTO> findAllOrderDetailByOrderId(Long orderId );

}
