package br.com.plataformavendas.plataformavendas;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evento {
    private Integer id;
    private String nome;
    private String descricao;
}
