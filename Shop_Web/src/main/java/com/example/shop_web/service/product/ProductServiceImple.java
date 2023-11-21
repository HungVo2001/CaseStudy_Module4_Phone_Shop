package com.example.shop_web.service.product;

import com.example.shop_web.domain.Product;
import java.util.List;
import java.util.Optional;

public class ProductServiceImple implements IProductService{
    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
