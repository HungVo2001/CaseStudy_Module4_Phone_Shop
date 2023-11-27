package com.example.shop_web.service.productImportDetail;

import com.example.shop_web.domain.ProductImport;
import com.example.shop_web.domain.ProductImportDetail;
import com.example.shop_web.repository.ProductImportDetailRepository;
import com.example.shop_web.repository.ProductImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class ProductImportDetailService implements IProductImportDetailService{
    @Autowired
    private ProductImportDetailRepository productImportDetailRepository;

    @Override
    public List<ProductImportDetail> findAll() {
        return null;
    }

    @Override
    public Optional<ProductImportDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductImportDetail save(ProductImportDetail productImportDetail) {
        return productImportDetailRepository.save(productImportDetail);
    }

    @Override
    public void update(ProductImportDetail productImportDetail) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
