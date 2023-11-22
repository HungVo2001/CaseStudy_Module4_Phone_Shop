package com.example.shop_web.service.product;

import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.service.IGeneralService;

import java.util.List;

public interface IProductService extends IGeneralService<Product,Long> {
    List<ProductResDTO> findAllProductResDTO(Boolean deleted);

}
