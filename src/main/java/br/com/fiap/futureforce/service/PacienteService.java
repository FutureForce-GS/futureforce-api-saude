package br.com.fiap.futureforce.service;

import br.com.fiap.futureforce.dto.PacienteDTO;
import br.com.fiap.futureforce.exception.ResourceNotFoundException;
import br.com.fiap.futureforce.model.Paciente;
import br.com.fiap.futureforce.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository repository;

    public List<PacienteDTO> listarTodos() {
        return repository.findAll().stream()
                .map(p -> new PacienteDTO(p.getId(), p.getNome(), p.getEmail(), p.getTelefone()))
                .collect(Collectors.toList());
    }

    public PacienteDTO buscarPorId(Long id) {
        Paciente p = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
        return new PacienteDTO(p.getId(), p.getNome(), p.getEmail(), p.getTelefone());
    }

    public PacienteDTO criar(PacienteDTO dto) {
        Paciente p = new Paciente();
        p.setNome(dto.nome());
        p.setEmail(dto.email());
        p.setTelefone(dto.telefone());

        Paciente salvo = repository.save(p);
        return new PacienteDTO(salvo.getId(), salvo.getNome(), salvo.getEmail(), salvo.getTelefone());
    }

    public PacienteDTO atualizar(Long id, PacienteDTO dto) {
        Paciente p = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
        p.setNome(dto.nome());
        p.setEmail(dto.email());
        p.setTelefone(dto.telefone());

        Paciente atualizado = repository.save(p);
        return new PacienteDTO(atualizado.getId(), atualizado.getNome(), atualizado.getEmail(), atualizado.getTelefone());
    }

    public void deletar(Long id) {
        repository.findById(id) // verifica se existe antes
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));
        repository.deleteById(id);
    }
}
