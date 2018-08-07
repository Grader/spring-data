package com.epam.sprdata.service;

import com.epam.sprdata.domain.Good;

import java.util.List;
import java.util.Optional;

public interface GoodService {

    List<Good> findByTagContaining(String tag);

    List<Good> findAllGood();

    Optional<Good> findById(Long id);

    Good save(Good good);
}
