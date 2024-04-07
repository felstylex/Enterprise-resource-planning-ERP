package com.ERP.controllers;

import com.ERP.dtos.FinancialTransactionRecordDto;
import com.ERP.models.transactions.FinancialTransaction;
import com.ERP.repositories.FinancialTransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinancialTransactionController {

    @Autowired
    FinancialTransactionRepository transactionRepository;

    @PostMapping("/transaction")
    public ResponseEntity<FinancialTransaction> saveTransaction(@RequestBody FinancialTransactionRecordDto transactionRecordDto) {
        var transactionModel = new FinancialTransaction();
        BeanUtils.copyProperties(transactionRecordDto, transactionModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transactionRepository.save(transactionModel));
    }

}
