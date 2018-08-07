package com.epam.sprdata.service.impl;

import com.epam.sprdata.domain.Good;
import com.epam.sprdata.repos.GoodRepo;
import com.epam.sprdata.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodRepo goodRepo;

    @Override
    public List<Good> findByTagContaining(String tag) {
        return goodRepo.findByTagContaining(tag);
    }

    @Override
    public List<Good> findAllGood() {
        return goodRepo.findAll();
    }

    @Override
    public Optional<Good> findById(Long id) {
        return goodRepo.findById(id);
    }

    @Override
    public Good save(Good good) {
        return goodRepo.saveAndFlush(good);
    }
}
