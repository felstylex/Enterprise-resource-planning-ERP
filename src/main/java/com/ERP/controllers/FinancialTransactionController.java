package com.ERP.controllers;

import com.ERP.repositories.FinancialTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancialTransactionController {

    @Autowired
    FinancialTransactionRepository transactionRepository;

}
