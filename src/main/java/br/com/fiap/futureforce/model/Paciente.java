package br.com.fiap.futureforce.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    // Relação: Um paciente tem muitos registros
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<RegistroDiario> registros;

    // Construtores, Getters e Setters
    public Paciente() {}

    public Paciente(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Gere os Getters e Setters aqui (Alt+Insert no IntelliJ)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}
