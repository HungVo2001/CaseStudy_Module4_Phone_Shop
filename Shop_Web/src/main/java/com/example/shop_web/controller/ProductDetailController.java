package com.example.shop_web.controller;


import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.User;
import com.example.shop_web.repository.ProductRepository;
import com.example.shop_web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/productDetail")
public class ProductDetailController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{idProduct}")
    public String showDetail(@PathVariable Long idProduct, Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        User userSession = userRepository.findByUsername(username).get();
        model.addAttribute("userId", userSession.getId());
        Optional<Product> product = productRepository.findById(idProduct);
        model.addAttribute("product", product.get());
        return "user/productDetail";
    }
}
