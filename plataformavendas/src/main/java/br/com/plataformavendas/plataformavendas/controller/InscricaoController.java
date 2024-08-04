package br.com.plataformavendas.plataformavendas.controller;

import br.com.plataformavendas.plataformavendas.model.Inscricao;
import br.com.plataformavendas.plataformavendas.exception.ResourceNotFoundException;
import br.com.plataformavendas.plataformavendas.service.InscricaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/eventos/{eventoId}/inscricoes")
public class InscricaoController {

    private final InscricaoService inscricaoService;

    @GetMapping
    public ResponseEntity<Collection<Inscricao>> findAll(@PathVariable UUID eventoId) {
        var inscricoes = inscricaoService.findAllByEventoId(eventoId);
        return ResponseEntity.ok(inscricoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscricao> findById(@PathVariable UUID eventoId, @PathVariable UUID id) {
        return inscricaoService.findByIdAndEventoId(id, eventoId)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Inscrição não encontrada com ID: " + id + " para o evento com ID: " + eventoId));
    }

    @PostMapping
    public ResponseEntity<Inscricao> save(@Valid @RequestBody Inscricao inscricao, @PathVariable UUID eventoId) {
        var savedInscricao = inscricaoService.save(inscricao, eventoId);
        return ResponseEntity.status(201).body(savedInscricao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscricao> update(@PathVariable UUID eventoId, @PathVariable UUID id, @Valid @RequestBody Inscricao inscricao) {
        var updatedInscricao = inscricaoService.update(id, eventoId, inscricao);
        return ResponseEntity.ok(updatedInscricao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID eventoId, @PathVariable UUID id) {
        inscricaoService.delete(id, eventoId);
        return ResponseEntity.noContent().build();
    }
}
