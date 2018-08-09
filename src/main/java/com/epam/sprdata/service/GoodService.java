package com.epam.sprdata.service;

import com.epam.sprdata.domain.Good;

import java.util.List;

public interface GoodService {

    List<Good> findByTagContaining(String tag);

    List<Good> findAllGood();

    Good findById(Long id);

    Good save(Good good);
}
