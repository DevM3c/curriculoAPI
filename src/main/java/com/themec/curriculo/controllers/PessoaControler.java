package com.themec.curriculo.controllers;

import com.themec.curriculo.entities.Pessoa;
import com.themec.curriculo.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaControler {
    @Autowired
    PessoaService service;

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa create(@RequestBody Pessoa pessoa){
        return service.create(pessoa);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> DeletePessoaById(@PathVariable(value = "id")Long id){
        return service.deleteById(id);
    }


}
