package com.ERP.controllers;

import com.ERP.dtos.ClientRecordDto;
import com.ERP.models.client.Client;
import com.ERP.repositories.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @PostMapping("/client")
    public ResponseEntity<Client> saveClient(@RequestBody ClientRecordDto clientRecordDto) {
        var clientModel = new Client();
        BeanUtils.copyProperties(clientRecordDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientRepository.save(clientModel));
    }

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Long id) {
        Optional<Client> client = clientRepository.findById(id);

        return  client.<ResponseEntity<Object>>map(value -> ResponseEntity.status(HttpStatus.OK)
                .body(value)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("cliente não encontrado!"));
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(value = "id") Long id, @RequestBody ClientRecordDto clientRecordDto) {

        Optional<Client> client = clientRepository.findById(id);

        if(client.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("cliente não encontrado!");
        }

        var clientModel = client.get();
        BeanUtils.copyProperties(clientRecordDto, clientModel);

        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(clientModel));

    }

}
