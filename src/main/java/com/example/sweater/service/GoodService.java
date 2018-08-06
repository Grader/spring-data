package com.example.sweater.service;

import com.example.sweater.domain.Cart;
import com.example.sweater.domain.Good;

import java.util.List;
import java.util.Optional;

public interface GoodService {

    List<Good> findByTagContaining(String tag);

    List<Good> findAllGood();

    Optional<Good> findById(Long id);

    Good save(Good good);
}
