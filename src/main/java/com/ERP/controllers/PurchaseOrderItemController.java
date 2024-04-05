package com.ERP.controllers;

import com.ERP.repositories.PurchaseOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseOrderItemController {

    @Autowired
    PurchaseOrderItemRepository orderItemRepository;
}
