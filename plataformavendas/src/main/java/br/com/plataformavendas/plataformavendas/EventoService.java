package br.com.plataformavendas.plataformavendas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public Collection<Evento> findAll() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> findById(UUID id) {
        return eventoRepository.findById(id);
    }

    public Evento save(Evento evento) {
        evento = eventoRepository.save(evento);
        return evento;
    }

    public Evento update(UUID id, Evento evento) {
        Evento buscaEvento = eventoRepository.getOne(id);
        buscaEvento.setNome(evento.getNome());
        buscaEvento.setDescricao(evento.getDescricao());
        buscaEvento.setDataInicio(evento.getDataInicio());
        buscaEvento.setDataTermino(evento.getDataTermino());
        buscaEvento.setPreco(evento.getPreco());
        buscaEvento = eventoRepository.save(buscaEvento);

        return buscaEvento;
    }

    public void delete(UUID id) {
        eventoRepository.deleteById(id);
    }

}
