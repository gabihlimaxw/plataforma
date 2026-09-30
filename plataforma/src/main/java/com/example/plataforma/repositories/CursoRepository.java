package com.example.plataforma.repositories;

import com.example.plataforma.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
