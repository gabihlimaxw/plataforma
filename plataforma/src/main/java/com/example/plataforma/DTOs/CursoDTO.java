package com.example.plataforma.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CursoDTO {
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private String cargaHoraria;
}