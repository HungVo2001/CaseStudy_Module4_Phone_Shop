package com.example.shop_web.service.cart;

import com.example.shop_web.domain.Cart;
import com.example.shop_web.domain.User;
import com.example.shop_web.service.IGeneralService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


public interface ICartService extends IGeneralService<Cart,Long> {
    void createCart(User newUser);
}
