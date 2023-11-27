package com.example.shop_web.service.productImport;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.ProductImport;
import com.example.shop_web.domain.dto.ProductImportDetailResponseDTO;
import com.example.shop_web.domain.dto.ProductImportResDTO;
import com.example.shop_web.domain.dto.ProductImportResponseDTO;
import com.example.shop_web.service.IGeneralService;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductImportService extends IGeneralService<ProductImport,Long> {
    List<ProductImportResDTO> findProductImportResDTo();
    ProductImportResDTO findProductImportResDToById( Long productImportId);
    ProductImportResponseDTO findProductImportResponseDTO(@Param("productImportId") Long productImportId );
    List<ProductImportDetailResponseDTO> findProductImportDetailResponseDTO(@Param("productImportId") Long productImportId );
}
