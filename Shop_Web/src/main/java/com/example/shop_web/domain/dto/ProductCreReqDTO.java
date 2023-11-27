package com.example.shop_web.domain.dto;

import com.example.shop_web.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCreReqDTO implements Validator {
    private String productName;
    private Long branchId;
    private String price;

    private String warrantyPeriod;
    private String ram;
    private String size;
    private String color;
    private String camera;
    private String operatingSystem;
    private String pin;

    public Product toProduct (){
        return  new Product()
                .setProductName(productName)
                .setPrice(BigDecimal.valueOf(Long.valueOf(price)))
                .setWarrantyPeriod(warrantyPeriod)
                .setRam(ram)
                .setSize(size)
                .setColor(color)
                .setCamera(camera)
                .setOperatingSystem(operatingSystem)
                .setPin(pin)
                ;
    }
public ProductResDTO toProductResDTO(){
        return  new ProductResDTO()
                .setProductName(productName)
                .setPrice(BigDecimal.valueOf(Long.valueOf(price)));

}

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
