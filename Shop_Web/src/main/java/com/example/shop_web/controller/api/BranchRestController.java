package com.example.shop_web.controller.api;

import com.example.shop_web.domain.dto.BranchResDTO;
import com.example.shop_web.domain.dto.ProductResDTO;
import com.example.shop_web.service.branch.IBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/branchs")
public class BranchRestController {

    @Autowired
    private IBranchService branchService;
    @GetMapping
    public ResponseEntity<?> getAll() {
        List<BranchResDTO> branchs = branchService.findAllBranchResDTO();
        return new ResponseEntity<>(branchs, HttpStatus.OK);
    }
}
