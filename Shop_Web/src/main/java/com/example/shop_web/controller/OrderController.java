package com.example.shop_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @GetMapping
    public String showCart(){
        return "user/userOrder";
    }
    @GetMapping("/confirmed")
    public String showConfirmed(){
        return "user/userOrderConfirmed";
    }
    @GetMapping("/canceled")
    public String showCanceled(){
        return "user/userOrderCanceled";
    }
}
