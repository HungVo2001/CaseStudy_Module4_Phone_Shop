package com.example.shop_web.controller.api;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.ProductImport;
import com.example.shop_web.domain.ProductImportDetail;
import com.example.shop_web.domain.dto.*;
import com.example.shop_web.domain.enumaration.EStatus;
import com.example.shop_web.repository.ProductImportRepository;
import com.example.shop_web.service.product.IProductService;
import com.example.shop_web.service.productImport.IProductImportService;
import com.example.shop_web.service.productImportDetail.IProductImportDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/product-imports")
public class ProductImportRestController {
    @Autowired
    private IProductImportService productImportService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductImportDetailService productImportDetailService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ProductImportResDTO> productImports = productImportService.findProductImportResDTo();
        return new ResponseEntity<>(productImports, HttpStatus.OK);
    }

    @GetMapping("/{productImportId}")
    public ResponseEntity<?> findById(@PathVariable Long productImportId) {
        ProductImportResponseDTO productImport = productImportService.findProductImportResponseDTO(productImportId);
        List<ProductImportDetailResponseDTO> productImportDetails = productImportService.findProductImportDetailResponseDTO(productImportId);
        productImport.setProductImportDetails(productImportDetails);
        return new ResponseEntity<>(productImport, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody ProductImportCreReqDTo productImportCreReqDTo, BindingResult bindingResult) {
        new ProductImportCreReqDTo().validate(productImportCreReqDTo, bindingResult);
        ProductImport productImport = productImportCreReqDTo.toProductImport();
        productImportService.save(productImport);
        BigDecimal totalAmount = BigDecimal.ZERO;
        List<ProductImportDetailCreReqDTO> productImportDetails = productImportCreReqDTo.getProductImportDetails();
        for (ProductImportDetailCreReqDTO pId : productImportDetails) {
            ProductImportDetail productImportDetail = new ProductImportDetail();
            productImportDetail.setProductImport(productImport);
            productImportDetail.setProduct(productService.findById(pId.getProductId()).get());
            productImportDetail.setQuantity(pId.getQuantity());
            productImportDetailService.save(productImportDetail);
            BigDecimal quantity = BigDecimal.valueOf((long) pId.getQuantity());
            BigDecimal price = productImportDetail.getProduct().getPrice();
            totalAmount = totalAmount.add(quantity.multiply((price)));
        }
        productImport.setTotalAmount(totalAmount);
        productImportService.save(productImport);
        List<ProductImportResDTO> productImports = productImportService.findProductImportResDTo();
        return new ResponseEntity<>(productImports.get(productImports.size()-1), HttpStatus.CREATED);
    }
}
