package com.example.shop_web.controller;
import com.example.shop_web.domain.User;
import com.example.shop_web.repository.CartDetailRepository;
import com.example.shop_web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String showCart(Authentication authentication, Model model){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if(authentication.getPrincipal() == null){
            return "user/login";
        }
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        User userSession = userRepository.findByUsername(username).get();
        model.addAttribute("userId", userSession.getId());
        return "user/layoutCarts";
    }
}
