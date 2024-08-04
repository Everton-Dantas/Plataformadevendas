package br.com.plataformavendas.plataformavendas.repository;

import br.com.plataformavendas.plataformavendas.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, UUID> {
    Collection<Inscricao> findAllByEventoId(UUID eventoId);
    Optional<Inscricao> findByIdAndEventoId(UUID id, UUID eventoId);
}
