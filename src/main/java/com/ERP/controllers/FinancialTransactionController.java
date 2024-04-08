package com.ERP.controllers;

import com.ERP.dtos.FinancialTransactionRecordDto;
import com.ERP.models.transactions.FinancialTransaction;
import com.ERP.repositories.FinancialTransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FinancialTransactionController {

    @Autowired
    FinancialTransactionRepository financialTransactionRepository;

    @PostMapping("/transaction")
    public ResponseEntity<FinancialTransaction> saveTransaction(@RequestBody FinancialTransactionRecordDto transactionRecordDto) {
        var transactionModel = new FinancialTransaction();
        BeanUtils.copyProperties(transactionRecordDto, transactionModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(financialTransactionRepository.save(transactionModel));
    }

    @GetMapping("/financial-transaction")
    public ResponseEntity<List<FinancialTransaction>> getAllFinancialTransactions() {
        return ResponseEntity.status(HttpStatus.OK).body(financialTransactionRepository.findAll());
    }

    @GetMapping("/financial-transaction/{id}")
    public ResponseEntity<Object> findFinancialTransactionById(@PathVariable(value = "id") Long id) {
        Optional<FinancialTransaction> financialTransaction = financialTransactionRepository.findById(id);

        return financialTransaction.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Transação financeira não encontrada!"));
    }

}
