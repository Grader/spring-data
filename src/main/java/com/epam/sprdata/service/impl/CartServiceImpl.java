package com.epam.sprdata.service.impl;

import com.epam.sprdata.domain.Cart;
import com.epam.sprdata.repos.CartRepo;
import com.epam.sprdata.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepo cartRepo;

    @Override
    public List<Cart> findByUserId(Long id) {
        return cartRepo.findByUserId(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepo.saveAndFlush(cart);
    }
}
