package br.com.plataformavendas.plataformavendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public ResponseEntity<Collection<Evento>> findAll() {
        var eventos = eventoService.findAll();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Evento>> findById(@PathVariable UUID id) {
        var evento = eventoService.findById(id);
        return ResponseEntity.ok(evento);
    }

    @PostMapping
    public ResponseEntity<Evento> save(@RequestBody Evento evento) {
        evento = eventoService.save(evento);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(evento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> update(@PathVariable UUID id, @RequestBody Evento evento) {
        evento = eventoService.update(id, evento);
        return ResponseEntity.ok(evento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        eventoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
