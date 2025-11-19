package br.com.fiap.futureforce.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tb_registro_diario")
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private Integer nivelAnsiedade; // 1 a 10
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public RegistroDiario() {}

    // Gere Getters e Setters (Alt+Insert)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public Integer getNivelAnsiedade() { return nivelAnsiedade; }
    public void setNivelAnsiedade(Integer nivelAnsiedade) { this.nivelAnsiedade = nivelAnsiedade; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }
}
