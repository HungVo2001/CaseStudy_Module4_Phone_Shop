package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.ProductImport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductImportDetailCreReqDTO {
    private int quantity;
    private Long productId;

}
