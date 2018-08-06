package com.example.sweater.service;

import com.example.sweater.domain.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findByUserId(Long id);

    Cart save(Cart cart);
}
