package br.com.plataformavendas.plataformavendas;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Inscricao {
    private Integer id;
    private String nome;
    private String email;
}
