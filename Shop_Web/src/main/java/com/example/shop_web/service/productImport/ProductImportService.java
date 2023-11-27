package com.example.shop_web.service.productImport;

import com.example.shop_web.domain.ProductImport;
import com.example.shop_web.domain.dto.ProductImportDetailResponseDTO;
import com.example.shop_web.domain.dto.ProductImportResDTO;
import com.example.shop_web.domain.dto.ProductImportResponseDTO;
import com.example.shop_web.repository.ProductImportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class ProductImportService implements IProductImportService{
    @Autowired
    private ProductImportRepository productImportRepository;
    @Override
    public List<ProductImport> findAll() {
        return productImportRepository.findAll();
    }

    @Override
    public Optional<ProductImport> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public ProductImport save(ProductImport productImport) {
        return productImportRepository.save(productImport);
    }


    @Override
    public void update(ProductImport productImport) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<ProductImportResDTO> findProductImportResDTo() {
        return productImportRepository.findProductImportResDTo();
    }

    @Override
    public ProductImportResDTO findProductImportResDToById(Long productImportId) {
        return null;
    }

    @Override
    public ProductImportResponseDTO findProductImportResponseDTO(Long productImportId) {
        return productImportRepository.findProductImportResponseDTO(productImportId);
    }

    @Override
    public List<ProductImportDetailResponseDTO> findProductImportDetailResponseDTO(Long productImportId) {
        return productImportRepository.findProductImportDetailResponseDTO(productImportId);
    }
}
