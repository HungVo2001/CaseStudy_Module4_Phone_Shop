package com.example.shop_web.domain.dto;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public interface ProductImportResDTO {
    Long getId() ;
    String getCode();
    Date getImport_date();
    String getProducts();
    BigDecimal getTotal_amount();


}
