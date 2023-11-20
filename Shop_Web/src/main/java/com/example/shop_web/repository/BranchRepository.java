package com.example.shop_web.repository;

import com.example.shop_web.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BranchRepository extends JpaRepository<Branch,Long> {
}
