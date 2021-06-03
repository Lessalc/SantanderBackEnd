package com.project.lessalc.santanderboot.controller;


import com.project.lessalc.santanderboot.model.dto.StockDTO;
import com.project.lessalc.santanderboot.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService service;

    /* MÉTODOS DE INSERÇÃO E ALTERAÇÃO NO BANCO DE DADOS */
    // No postmapping podemos dizer o tipo de dado que ele vai consumir e o tipo que vai gerar
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){

        return ResponseEntity.ok(service.update(dto));
    }

    /* MÉTODOS DE CONSULTA NO BANCO DE DADOS */

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday(){

        return ResponseEntity.ok(service.findByToday());
    }

    /* MÉTODO DE EXCLUSÃO DO BANCO DE DADOS */

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

}
