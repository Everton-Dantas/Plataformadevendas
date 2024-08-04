package br.com.plataformavendas.plataformavendas.service;

import br.com.plataformavendas.plataformavendas.model.Evento;
import br.com.plataformavendas.plataformavendas.exception.ResourceNotFoundException;
import br.com.plataformavendas.plataformavendas.repository.EventoRepository;
import lombok.AllArgsConstructor;
import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public Collection<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> findById(UUID id) {
        return eventoRepository.findById(id);
    }

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento update(UUID id, Evento evento) {
        return eventoRepository.findById(id).map(existingEvento -> {
            existingEvento.setNome(evento.getNome());
            existingEvento.setDescricao(evento.getDescricao());
            existingEvento.setDataInicio(evento.getDataInicio());
            existingEvento.setDataTermino(evento.getDataTermino());
            existingEvento.setPreco(evento.getPreco());
            return eventoRepository.save(existingEvento);
        }).orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com ID: " + id));
    }

    public void delete(UUID id) {
        if(!eventoRepository.existsById(id)) {
            throw new ResourceClosedException("Evento não encontrado com ID: " + id);
        }
        eventoRepository.deleteById(id);
    }

}
