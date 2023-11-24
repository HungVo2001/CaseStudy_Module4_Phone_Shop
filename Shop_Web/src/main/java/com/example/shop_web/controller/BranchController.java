package com.example.shop_web.controller;

import com.example.shop_web.domain.dto.ProductResDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/branchs")
public class BranchController {
    @GetMapping()
    public String showProduct(Model model) {
        return "admin/adminBranch";
    }
}
