package com.example.shop_web.controller.api;

import com.example.shop_web.domain.Order;
import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.User;
import com.example.shop_web.domain.dto.*;
import com.example.shop_web.domain.enumaration.EStatus;
import com.example.shop_web.service.branch.IBranchService;
import com.example.shop_web.service.order.IOrderService;
import com.example.shop_web.service.orderDetail.IOrderDetailService;
import com.example.shop_web.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderRestController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IOrderDetailService orderDetailService;
    @Autowired
    private IUserService userService;

    @GetMapping("/confirming/user")
    public ResponseEntity<?> getAllOrderConfirmingByUser() {
//        User user= userService.getCurrentUser().get();


        Long id  = 1L;



        List<OrderResDTO> orders = orderService.findAllOrderResDTOByUserAndStatus(EStatus.CONFIRMING,id);
        for (OrderResDTO ord : orders) {
        List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
        ord.setOrderDetails(orderDetails);
    }
        return new ResponseEntity<>(orders, HttpStatus.OK);
}

    @GetMapping("/canceled/user")
    public ResponseEntity<?> getAllOrderCanceledByUser() {


//        User user= userService.getCurrentUser().get();
        Long id  = 1L;

        List<OrderResDTO> orders = orderService.findAllOrderResDTOByUserAndStatus(EStatus.CANCELED,id);
        for (OrderResDTO ord : orders) {
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/confirmed/user")
    public ResponseEntity<?> getAllOrderConfirmedByUser() {

//        User user= userService.getCurrentUser().get();
        Long id  = 1L;


        List<OrderResDTO> orders = orderService.findAllOrderResDTOByUserAndStatus(EStatus.CONFIRMED,id);
        for (OrderResDTO ord : orders) {
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/confirming")
    public ResponseEntity<?> getAllOrderConfirming() {
        List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CONFIRMING);
        for (OrderResDTO ord : orders) {
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/confirmed")
    public ResponseEntity<?> getAllOrderConfirmed() {
        List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CONFIRMED);
        for (OrderResDTO ord : orders) {
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/canceled")
    public ResponseEntity<?> getAllOrderCanceled() {
        List<OrderResDTO> orders = orderService.findAllOrderByStatus(EStatus.CANCELED);
        for (OrderResDTO ord : orders) {
            List<OrderDetailResDTO> orderDetails = orderDetailService.findAllOrderDetailByOrderId(ord.getId());
            ord.setOrderDetails(orderDetails);
        }
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<?> findById(@PathVariable Long idOrder) {
        OrderResDTO order = orderService.findOrderResDTOByOrderId(idOrder);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/orderDetails/{idOrder}")
    public ResponseEntity<?> findOrderDetailsById(@PathVariable Long idOrder) {
        List<OrderDetailResDTO> orderdetails = orderDetailService.findAllOrderDetailByOrderId(idOrder);
        return new ResponseEntity<>(orderdetails, HttpStatus.OK);
    }

    @PatchMapping("/confirmOrder/{idOrder}")
    public ResponseEntity<?> confirm(@RequestBody OrderReqDTO orderReqDTO, @PathVariable Long idOrder) {
        Order order = orderService.findById(idOrder).get();
        order.setStatus(EStatus.CONFIRMED);
        orderService.save(order);
        return new ResponseEntity<>(orderReqDTO, HttpStatus.OK);
    }

    @PatchMapping("/cancelOrder/{idOrder}")
    public ResponseEntity<?> cancel(@RequestBody OrderReqDTO orderReqDTO, @PathVariable Long idOrder) {
        Order order = orderService.findById(idOrder).get();
        order.setStatus(EStatus.CANCELED);
        orderService.save(order);
        return new ResponseEntity<>(orderReqDTO, HttpStatus.OK);
    }

}
