package com.example.shop_web.repository;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.ProductImport;
import com.example.shop_web.domain.dto.ProductImportDetailResponseDTO;
import com.example.shop_web.domain.dto.ProductImportResDTO;
import com.example.shop_web.domain.dto.ProductImportResponseDTO;
import com.example.shop_web.domain.dto.ProductResDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImportRepository  extends JpaRepository<ProductImport,Long> {
    @Query(value = "SELECT pi.id, \n" +
            "            pi.code,  \n" +
            "            pi.import_date,  \n" +
            "            GROUP_CONCAT(p.product_name) AS products, \n" +
            "             pi.total_amount \n" +
            "            FROM product_imports pi \n" +
            "            LEFT JOIN product_import_details pid ON pi.id = pid.product_import_id \n" +
            "            LEFT JOIN products p ON p.id = pid.product_id \n" +
            "            GROUP BY pi.id ", nativeQuery = true)
    List<ProductImportResDTO> findProductImportResDTo();

    @Query("SELECT NEW com.example.shop_web.domain.dto.ProductImportResponseDTO  ( " +
            "Pi.code, " +
            "Pi.importDate, " +
            "Pi.totalAmount " +
            ") " +
            "FROM ProductImport AS Pi WHERE Pi.id = :productImportId"
    )
    ProductImportResponseDTO findProductImportResponseDTO(@Param("productImportId") Long productImportId );
    ;
    @Query("SELECT NEW com.example.shop_web.domain.dto.ProductImportDetailResponseDTO ( " +
            "Pid.quantity, " +
            "Pid.product " +
            ") " +
            "FROM ProductImportDetail AS Pid WHERE Pid.productImport.id = :productImportId"
    )
    List<ProductImportDetailResponseDTO> findProductImportDetailResponseDTO(@Param("productImportId") Long productImportId );
    ;
}
