package com.themec.curriculo.controllers;

import com.themec.curriculo.entities.Curriculo;
import com.themec.curriculo.services.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/curriculo")
public class CurriculoControler {
    @Autowired
    CurriculoService service;

    @GetMapping(value = "/{id}")
    public Curriculo findById(@PathVariable Long id){
        return service.findById(id);
    }
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Curriculo create(@RequestBody Curriculo curriculo){
        return service.create(curriculo);
    }
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> DeleteCurriculoById(@PathVariable(value = "id")Long id){
        return service.deleteById(id);
    }
}
