package com.example.shop_web.controller.api;

import com.example.shop_web.domain.dto.OrderDetailResDTO;
import com.example.shop_web.domain.dto.OrderResDTO;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.domain.enumaration.EStatus;
import com.example.shop_web.service.branch.IBranchService;
import com.example.shop_web.service.order.IOrderService;
import com.example.shop_web.service.orderDetail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping("/confirming")
    public ResponseEntity<?> getAllOrderConfirming() {
        List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CONFIRMING);
        for (OrderResDTO ord :orders){
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/confirmed")
    public ResponseEntity<?> getAllOrderConfirmed() {
        List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CONFIRMED);
        for (OrderResDTO ord :orders){
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    @GetMapping("/canceled")
    public ResponseEntity<?> getAllOrderCanceled() {
        List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CANCELED);
        for (OrderResDTO ord :orders){
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}
