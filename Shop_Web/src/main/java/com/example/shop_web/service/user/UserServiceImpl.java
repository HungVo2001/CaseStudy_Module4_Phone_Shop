package com.example.shop_web.service.user;

import com.example.shop_web.domain.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements IUserService{
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
