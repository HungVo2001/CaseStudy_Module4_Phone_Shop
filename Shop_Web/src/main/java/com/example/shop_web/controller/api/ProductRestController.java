package com.example.shop_web.controller.api;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.ProductCreReqDTO;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.service.branch.IBranchService;
import com.example.shop_web.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IBranchService branchService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<ProductResDTO> products = productService.findAllProductResDTO(false);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody ProductCreReqDTO productCreReqDTO, BindingResult bindingResult) {
        new ProductCreReqDTO().validate(productCreReqDTO, bindingResult);
        Product product = productCreReqDTO.toProduct();
        Branch branch = branchService.findByBranchId(productCreReqDTO.getBranchId());
        product.setBranch(branch);
        product.setQuantity(0);
        product.setDeleted(true);
        productService.save(product);
        ProductResDTO productResDTO = productCreReqDTO.toProductResDTO();
        productResDTO.setBranch(branch.toBranchReqDTO());
        productResDTO.setPrice(product.getPrice());
        productResDTO.setId(product.getId());
        return new ResponseEntity<>(productResDTO, HttpStatus.CREATED);

    }
    @GetMapping("/{idProduct}")
    public ResponseEntity<?> findByid(@PathVariable long idProduct){
      ProductResDTO productResDTO = productService.findProductResDTO(idProduct);
        return  new ResponseEntity<>(productResDTO,HttpStatus.OK);
    }
}
