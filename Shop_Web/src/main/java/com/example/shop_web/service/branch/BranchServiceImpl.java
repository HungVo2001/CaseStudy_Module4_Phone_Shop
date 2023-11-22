package com.example.shop_web.service.branch;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.User;
import com.example.shop_web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BranchServiceImpl implements  IBranchService {


    @Override
    public List<Branch> findAll() {
        return null;
    }

    @Override
    public Optional<Branch> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Branch save(Branch branch) {
        return null;
    }

//    @Override
//    public User save(Branch branch) {
//
//    }

    @Override
    public void update(Branch branch) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
