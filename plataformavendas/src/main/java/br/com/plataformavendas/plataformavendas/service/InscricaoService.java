package br.com.plataformavendas.plataformavendas.service;

import br.com.plataformavendas.plataformavendas.model.Inscricao;
import br.com.plataformavendas.plataformavendas.exception.InvalidPaymentException;
import br.com.plataformavendas.plataformavendas.exception.ResourceNotFoundException;
import br.com.plataformavendas.plataformavendas.repository.EventoRepository;
import br.com.plataformavendas.plataformavendas.repository.InscricaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final EventoRepository eventoRepository;

    public Collection<Inscricao> findAllByEventoId(UUID eventoId) {
        return inscricaoRepository.findAllByEventoId(eventoId);
    }

    public Optional<Inscricao> findByIdAndEventoId(UUID id, UUID eventoId) {
        return inscricaoRepository.findByIdAndEventoId(id, eventoId);
    }

    public Inscricao save(Inscricao inscricao, UUID eventoId) {
        var evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new ResourceNotFoundException("Evento não encontrado com ID: " + eventoId));

        if (inscricao.getPrecoPago() != evento.getPreco()) {
            throw new InvalidPaymentException("O preço pago não corresponde ao preço do evento.");
        }

        inscricao.setEvento(evento);
        return inscricaoRepository.save(inscricao);
    }

    public Inscricao update(UUID id, UUID eventoId, Inscricao inscricao) {
        return inscricaoRepository.findByIdAndEventoId(id, eventoId).map(existingInscricao -> {
            if (inscricao.getPrecoPago() != existingInscricao.getEvento().getPreco()) {
                throw new InvalidPaymentException("O preço pago não corresponde ao preço do evento.");
            }
            existingInscricao.setCpf(inscricao.getCpf());
            existingInscricao.setEmail(inscricao.getEmail());
            existingInscricao.setPrecoPago(inscricao.getPrecoPago());
            return inscricaoRepository.save(existingInscricao);
        }).orElseThrow(() -> new ResourceNotFoundException("Inscrição não encontrada com ID: " + id + " para o evento com ID: " + eventoId));
    }

    public void delete(UUID id, UUID eventoId) {
        var inscricao = inscricaoRepository.findByIdAndEventoId(id, eventoId)
                .orElseThrow(() -> new ResourceNotFoundException("Inscrição não encontrada com ID: " + id + " para o evento com ID: " + eventoId));
        inscricaoRepository.delete(inscricao);
    }
}
