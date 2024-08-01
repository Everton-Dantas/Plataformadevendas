package br.com.plataformavendas.plataformavendas;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_evento")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Nome do evento é obrigatório")
    private String nome;

    private String descricao;

    @NotNull(message = "Data de início do evento é obrigatória")
    private LocalDateTime dataInicio;

    @NotNull(message = "Data de término do evento é obrigatória")
    private LocalDateTime dataTermino;

    @NotNull(message = "Preço do evento é obrigatório")
    private double preco;

    public Evento(String nome, String descricao,LocalDateTime dataInicio, LocalDateTime dataTermino, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.preco = preco;
    }
}
