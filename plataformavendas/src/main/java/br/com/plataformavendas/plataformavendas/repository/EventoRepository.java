package br.com.plataformavendas.plataformavendas.repository;

import br.com.plataformavendas.plataformavendas.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, UUID> {
}
