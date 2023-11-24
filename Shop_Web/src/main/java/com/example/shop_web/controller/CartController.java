package com.example.shop_web.controller;

import com.example.shop_web.domain.CartDetail;
import com.example.shop_web.domain.dto.CartDetailCreDTO;
import com.example.shop_web.repository.CartDetailRepository;
import com.example.shop_web.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartDetailRepository cartDetailRepository;
    @GetMapping("/{idUser}") // chỗ này lấy Session user về gắn id vào chứ ko gắn id như này
    public String showCart(@PathVariable Long idUser, Model model){
        List<CartDetail> cart = cartDetailRepository.getAllByUser_Id(idUser);
        model.addAttribute("cart", cart);
            return "user/cart";
    }
}
