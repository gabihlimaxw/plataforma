package com.example.plataforma.repositories;

import com.example.plataforma.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Collection;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {


}
