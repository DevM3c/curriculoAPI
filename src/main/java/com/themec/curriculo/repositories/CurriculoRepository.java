package com.themec.curriculo.repositories;

import com.themec.curriculo.entities.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
}
