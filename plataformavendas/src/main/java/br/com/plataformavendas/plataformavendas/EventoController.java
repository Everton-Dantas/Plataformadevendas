package br.com.plataformavendas.plataformavendas;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    @GetMapping
    public ResponseEntity<Collection<Evento>> findAll() {
        var eventos = eventoService.findAll();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> findById(@PathVariable UUID id) {
        return eventoService.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com ID: " + id));
    }

    @PostMapping
    public ResponseEntity<Evento> save(@Valid @RequestBody Evento evento) {
        var savedEvento = eventoService.save(evento);
        return ResponseEntity.status(201).body(savedEvento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@PathVariable UUID id, @Valid @RequestBody Evento evento) {
        var updatedEvento = eventoService.update(id, evento);
        return ResponseEntity.ok(updatedEvento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
