package com.themec.curriculo.services;

import com.themec.curriculo.entities.Pessoa;
import com.themec.curriculo.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository repository;

    @Transactional
    public Pessoa findById(Long id){
        Pessoa result = repository.findById(id).get();
        return result;
    }

    public Pessoa create(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public ResponseEntity<Object> deleteById(Long id){
        return repository.findById(id)
                .map(pessoaToDelete ->{
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
