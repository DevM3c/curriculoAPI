package com.themec.curriculo.services;

import com.themec.curriculo.entities.Curriculo;
import com.themec.curriculo.repositories.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurriculoService {

    @Autowired
    CurriculoRepository repository;

    @Transactional(readOnly = true)
    public Curriculo findById(Long id){
        Curriculo result = repository.findById(id).get();
        return result;
    }

    public Curriculo create(Curriculo curriculo){
        return repository.save(curriculo);
    }

    public ResponseEntity<Object> deleteById(Long id){
        return repository.findById(id)
                .map(curriculoToDelete ->{
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
