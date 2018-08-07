package com.epam.sprdata.service;

import com.epam.sprdata.domain.Cart;

import java.util.List;

public interface CartService {

    List<Cart> findByUserId(Long id);

    Cart save(Cart cart);
}
