package com.example.plataforma.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String nome;
    @NotBlank @Email @Column(length = 150)
    private String email;

    @ManyToMany
    @JoinTable(name = "matricula",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns =@JoinColumn(name = "curso_id"))
    private Set<Curso> matricula = new HashSet<>();

}