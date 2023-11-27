package com.example.shop_web.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductImportResponseDTO {
    private String code;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private java.util.Date importDate;
    private BigDecimal totalAmount;
    private List<ProductImportDetailResponseDTO> productImportDetails;
    public ProductImportResponseDTO(String code, Date importDate, BigDecimal totalAmount){
        this.code = code;
        this.importDate =importDate;
        this.totalAmount = totalAmount;
    }
}
