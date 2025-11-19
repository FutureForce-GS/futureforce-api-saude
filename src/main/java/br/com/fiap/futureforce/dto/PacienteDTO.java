package br.com.fiap.futureforce.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PacienteDTO(
        Long id,
        @NotBlank(message = "O nome é obrigatório") String nome,
        @Email(message = "Email inválido") String email,
        String telefone
) {}
