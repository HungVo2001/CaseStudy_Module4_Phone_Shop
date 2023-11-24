package com.example.shop_web.service.product;

import com.example.shop_web.domain.Product;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.repository.ProductRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImple implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);

    }


    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<ProductResDTO> findAllProductResDTO(Boolean deleted) {
        return productRepository.findAllProductResDTO(deleted);
    }

    @Override
    public ProductResDTO findProductResDTO(Long productId) {
        return productRepository.findProductResDTO(productId);
    }
}
