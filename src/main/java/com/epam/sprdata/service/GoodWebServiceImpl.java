package com.epam.sprdata.service;

import com.epam.sprdata.domain.Good;
import com.epam.sprdata.repos.GoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodWebServiceImpl implements GoodWebService {

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
    public Good findById(Long id) {
        return goodRepo.findById(id).orElse(new Good());
    }

    @Override
    public Good save(Good good) {
        return goodRepo.saveAndFlush(good);
    }
}
