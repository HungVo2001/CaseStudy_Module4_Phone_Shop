package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class OrderDetailResDTO {
    private int quantity;
    private BigDecimal totalAmount;
    private ProductResOrderDTO product;
    public OrderDetailResDTO(int quantity, BigDecimal totalAmount, Product product) {
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.product = product.toProDuctResOrderDTO();
    }
}
