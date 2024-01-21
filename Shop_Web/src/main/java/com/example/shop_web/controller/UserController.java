package com.example.shop_web.controller;


import com.example.shop_web.domain.User;
import com.example.shop_web.repository.UserRepository;
import lombok.AllArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("")
@AllArgsConstructor
public class UserController {
@Autowired
private UserRepository userRepository;
    @GetMapping("/home")
    public String showHomePage(Model model, Authentication authentication) {
        if(authentication == null){
            return "user/layoutHome";
        }
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        // Kiểm tra vai trò và thêm vào model nếu cần
        if (userDetails.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("ROLE_ADMIN"))) {
            model.addAttribute("isAdmin", true);
        } else {
            model.addAttribute("isUser",true);
        }
        User userSession = userRepository.findByUsername(username).get();
        model.addAttribute("userId", userSession.getId());
        return "user/layoutHome";
    }
    @GetMapping("/default")
    public String defaultAfterLogin(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin"; // Điều hướng đến trang admin nếu có vai trò ADMIN
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
            return "redirect:/home"; // Điều hướng đến trang user nếu có vai trò USER
        } else {
            throw new IllegalStateException("Vai trò không hợp lệ.");
        }
    }

//    @GetMapping("/home")
//    public String showHomePage() {
//        return "user/layoutHome";
//    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login";
    }
}
