package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductImportDetailResponseDTO {
    private int quantity;
    private ProductResponseDTO product;
    public  ProductImportDetailResponseDTO(int quantity, Product product){
        this.quantity=quantity;
        this.product=product.toProductResponseDTO();
    }
}
