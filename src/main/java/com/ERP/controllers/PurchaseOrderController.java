package com.ERP.controllers;

import com.ERP.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderRepository orderRepository;
}