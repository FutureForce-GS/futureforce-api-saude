package br.com.fiap.futureforce.config;

import br.com.fiap.futureforce.model.Paciente;
import br.com.fiap.futureforce.model.RegistroDiario;
import br.com.fiap.futureforce.repository.PacienteRepository;
import br.com.fiap.futureforce.repository.RegistroDiarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataSeeder implements CommandLineRunner {

    private final PacienteRepository pacienteRepository;
    private final RegistroDiarioRepository registroRepository; // Adicionamos o repositório de registros

    // Injeção de dependência via construtor
    public DataSeeder(PacienteRepository pacienteRepository, RegistroDiarioRepository registroRepository) {
        this.pacienteRepository = pacienteRepository;
        this.registroRepository = registroRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Paciente p1 = new Paciente(null, "João Silva", "joao@fiap.com.br", "11999999999");
        Paciente p2 = new Paciente(null, "Maria Alice", "maria@fiap.com.br", "11988888888");

        pacienteRepository.saveAll(List.of(p1, p2));

        RegistroDiario r1 = new RegistroDiario();
        r1.setData(LocalDate.now().minusDays(1)); // Ontem
        r1.setNivelAnsiedade(3);
        r1.setDescricao("Dia tranquilo, consegui focar nos estudos.");
        r1.setPaciente(p1);

        RegistroDiario r2 = new RegistroDiario();
        r2.setData(LocalDate.now()); // Hoje
        r2.setNivelAnsiedade(8);
        r2.setDescricao("Um pouco estressado com o prazo da Global Solution.");
        r2.setPaciente(p1);

        registroRepository.saveAll(List.of(r1, r2));

        System.out.println("--- Seeds Carregados: 2 Pacientes e 2 Registros Diários ---");
    }
}
