package com.ERP.controllers;

import com.ERP.dtos.ProductRecordDto;
import com.ERP.models.products.Product;
import com.ERP.repositories.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody ProductRecordDto productRecordDto) {
        var productModel = new Product();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productRepository.save(productModel));
    }
}
