package com.ERP.controllers;

import com.ERP.dtos.ClientRecordDto;
import com.ERP.models.client.Client;
import com.ERP.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/client")
    public ResponseEntity<Client> SaveClient(@RequestBody ClientRecordDto clientRecordDto) {
        var clientModel = new Client();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientRepository.save(clientModel));
    }


    @GetMapping("/client")
    public ResponseEntity<List<Client>> GetAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
    }

}
