package br.com.fiap.futureforce.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record RegistroDiarioDTO(
        Long id,
        @NotNull LocalDate data,
        @Min(1) @Max(10) Integer nivelAnsiedade,
        String descricao,
        @NotNull Long pacienteId
) {}
