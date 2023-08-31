package com.example.tecnico.repository;

import com.example.tecnico.entity.UnidadeSaude;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnidadeSaudeRepository extends JpaRepository<UnidadeSaude, Integer> {
    UnidadeSaude findById(Long unidadeSaude);
}
