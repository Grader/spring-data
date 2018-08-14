package com.epam.sprdata.rest;

import com.epam.sprdata.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;



@RestController
public class RESTControllerExample {

    @Autowired
    private GoodService goodService;

    @RequestMapping(value = "/goods", method = RequestMethod.GET)
    public Collection getEmployeeNames() {
        return goodService.findAllGood();
    }
}
