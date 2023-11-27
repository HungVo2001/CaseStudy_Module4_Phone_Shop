package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.ProductImport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductImportCreReqDTo implements Validator {
    private String code;
    private Date importDate;
    private  List<ProductImportDetailCreReqDTO> productImportDetails ;

    public ProductImport toProductImport(){
        return new ProductImport()
                .setCode(code)
                .setImportDate(importDate);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
