package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.Branch;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductResDTO implements Validator {
private Long id ;
private String productName;
private BranchResDTO branch;
private int quantity;
private BigDecimal price;
//private ImageReqDTO imageReqDTO;
public ProductResDTO(Long id, String productName, Branch branch  , int quantity , BigDecimal price){
    this.id = id;
    this.productName = productName;
    this.branch = branch.toBranchReqDTO();
    this.quantity = quantity;
    this.price= price;
}



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
