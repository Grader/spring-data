package com.epam.sprdata.service;

import com.epam.sprdata.domain.Good;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "GoodWebService")
public interface GoodWebService {

    @WebMethod()
    @WebResult(name = "Good")
    List<Good> findByTagContaining(@WebParam(name = "GoodRequest") String tag);

    @WebMethod()
    @WebResult(name = "Good")
    List<Good> findAllGood();

    @WebMethod()
    @WebResult(name = "Good")
    Good findById(@WebParam(name = "GoodRequest") Long id);

    @WebMethod()
    @WebResult(name = "Good")
    Good save(@WebParam(name = "GoodRequest") Good good);
}
