package com.example.shop_web.service.product;

import com.example.shop_web.domain.Product;
<<<<<<< HEAD
=======
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

>>>>>>> 201b73342554c322b0b1d87c3cf3347c4aca8a5d
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProductServiceImple implements IProductService{

    @Autowired
    private ProductRepository productRepository;
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

    @Override
    public List<ProductResDTO> findAllProductResDTO() {
        return productRepository.findAllProductResDTO() ;
    }
}
