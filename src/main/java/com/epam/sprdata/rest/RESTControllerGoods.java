package com.epam.sprdata.rest;

import com.epam.sprdata.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RESTControllerGoods {

    @Autowired
    private GoodService goodService;

    @GetMapping("/goods")
    public Collection getAllGoods() {
        return goodService.findAllGood();
    }

    @GetMapping("/goods/{tag}")
    public Collection getGoods(@PathVariable String tag) {
        return goodService.findByTagContaining(tag);
    }
}
