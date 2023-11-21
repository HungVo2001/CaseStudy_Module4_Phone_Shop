package com.example.shop_web.repository;

import com.example.shop_web.domain.Branch;
import com.example.shop_web.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


    Optional<User> findByUserNameIgnoreCaseOrEmailIgnoreCaseOrPhone(String userName, String email, String phone);

    boolean existsByUserNameIgnoreCase (String userName);

    boolean existsByEmailIgnoreCase (String email);

    boolean existsByPhone (String phone);

    boolean existsByAddress (String address);
}
