package br.com.fiap.futureforce.controller;

import br.com.fiap.futureforce.dto.RegistroDiarioDTO;
import br.com.fiap.futureforce.service.RegistroDiarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros-diarios") // <--- Essa linha define a URL
public class RegistroDiarioController {

    @Autowired
    private RegistroDiarioService service;

    // 1. Listar todos
    @GetMapping
    public ResponseEntity<List<RegistroDiarioDTO>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // 2. Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<RegistroDiarioDTO> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // 3. Criar novo
    @PostMapping
    public ResponseEntity<RegistroDiarioDTO> criar(@RequestBody @Valid RegistroDiarioDTO dto) {
        RegistroDiarioDTO novoRegistro = service.criar(dto);
        return ResponseEntity.status(201).body(novoRegistro);
    }

    // 4. Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<RegistroDiarioDTO> atualizar(@PathVariable Long id, @RequestBody @Valid RegistroDiarioDTO dto) {
        return ResponseEntity.ok(service.atualizar(id, dto));
    }

    // 5. Remover
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
