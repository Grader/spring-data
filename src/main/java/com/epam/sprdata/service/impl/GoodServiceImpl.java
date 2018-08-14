package com.epam.sprdata.service.impl;

import com.epam.sprdata.domain.Good;
import com.epam.sprdata.repos.GoodRepo;
import com.epam.sprdata.repos.GoodRepoJdbc;
import com.epam.sprdata.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodRepo goodRepo;

    @Autowired
    private GoodRepoJdbc goodRepoJdbc;

    @Override
    public List<Good> findAllGood() {
        return goodRepoJdbc.findAll();
    }

    @Override
    public Good save(Good good) {
        return goodRepo.saveAndFlush(good);
    }

    @Override
    public Good findById(Long id) {
        return goodRepoJdbc.findGoodById(id);
    }

    @Override
    public List<Good> findByTagContaining(String tag) {
        return goodRepoJdbc.findByTagContaining(tag);
    }

//        @Override
//    public Good save(Good good) {
//        return goodRepoJdbc.create(good);
//    }

//    @Override
//    public Optional<Good> findById(Long id) {
//        return goodRepo.findById(id);
//    }
//

//    @Override
//    public List<Good> findByTagContaining(String tag) {
//        return goodRepo.findByTagContaining(tag);
//    }

}
