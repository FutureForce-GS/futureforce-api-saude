package br.com.fiap.futureforce.service;

import br.com.fiap.futureforce.dto.RegistroDiarioDTO;
import br.com.fiap.futureforce.exception.ResourceNotFoundException;
import br.com.fiap.futureforce.model.Paciente;
import br.com.fiap.futureforce.model.RegistroDiario;
import br.com.fiap.futureforce.repository.PacienteRepository;
import br.com.fiap.futureforce.repository.RegistroDiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors; // <-- Certifique-se de ter este import

@Service
public class RegistroDiarioService {

    @Autowired
    private RegistroDiarioRepository registroRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    // --- O método que estava faltando ---
    public List<RegistroDiarioDTO> listarTodos() {
        return registroRepository.findAll().stream()
                .map(r -> new RegistroDiarioDTO(
                        r.getId(),
                        r.getData(),
                        r.getNivelAnsiedade(),
                        r.getDescricao(),
                        r.getPaciente().getId()
                ))
                .collect(Collectors.toList());
    }
    // ------------------------------------

    public RegistroDiarioDTO buscarPorId(Long id) {
        RegistroDiario r = registroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado"));
        return new RegistroDiarioDTO(r.getId(), r.getData(), r.getNivelAnsiedade(), r.getDescricao(), r.getPaciente().getId());
    }

    public RegistroDiarioDTO criar(RegistroDiarioDTO dto) {
        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        RegistroDiario r = new RegistroDiario();
        r.setData(dto.data());
        r.setNivelAnsiedade(dto.nivelAnsiedade());
        r.setDescricao(dto.descricao());
        r.setPaciente(paciente);

        RegistroDiario salvo = registroRepository.save(r);
        return new RegistroDiarioDTO(salvo.getId(), salvo.getData(), salvo.getNivelAnsiedade(), salvo.getDescricao(), salvo.getPaciente().getId());
    }

    public RegistroDiarioDTO atualizar(Long id, RegistroDiarioDTO dto) {
        RegistroDiario r = registroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado"));

        r.setData(dto.data());
        r.setNivelAnsiedade(dto.nivelAnsiedade());
        r.setDescricao(dto.descricao());
        // Normalmente não atualizamos o paciente vinculado, mas se precisar, busque novamente aqui.

        RegistroDiario salvo = registroRepository.save(r);
        return new RegistroDiarioDTO(salvo.getId(), salvo.getData(), salvo.getNivelAnsiedade(), salvo.getDescricao(), salvo.getPaciente().getId());
    }

    public void deletar(Long id) {
        if (!registroRepository.existsById(id)) { // verificação simplificada
            throw new ResourceNotFoundException("Registro não encontrado");
        }
        registroRepository.deleteById(id);
    }
}
