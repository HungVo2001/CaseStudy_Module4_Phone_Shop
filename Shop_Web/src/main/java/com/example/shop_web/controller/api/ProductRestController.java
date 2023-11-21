package com.example.shop_web.controller.api;

import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ProductResDTO> products = productService.findAllProductResDTO();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
