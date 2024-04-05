package com.ERP.controllers;

import com.ERP.repositories.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesOrderController {

    @Autowired
    SalesOrderRepository salesOrderRepository;
}
