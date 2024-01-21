package com.example.shop_web.service.cart;

import com.example.shop_web.domain.Cart;
import com.example.shop_web.domain.User;
import com.example.shop_web.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class CartServiceImpl implements ICartService {
    @Autowired
    CartRepository cartRepository;
    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Cart save(Cart cart) {
        return null;
    }


    @Override
    public void update(Cart cart) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void createCart(User newUser) {
        Cart cart = new Cart();
        cart.setTotalAmount(BigDecimal.ZERO);
        cart.setUser(newUser);
        cartRepository.save(cart);
    }
}
