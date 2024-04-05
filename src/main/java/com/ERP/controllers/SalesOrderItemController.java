package com.ERP.controllers;

import com.ERP.repositories.SalesOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesOrderItemController {

    @Autowired
    SalesOrderItemRepository orderItemRepository;
}
