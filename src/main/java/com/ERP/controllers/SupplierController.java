package com.ERP.controllers;

import com.ERP.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepository;
}
