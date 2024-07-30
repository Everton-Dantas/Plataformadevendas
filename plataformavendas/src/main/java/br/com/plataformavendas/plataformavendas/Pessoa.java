package br.com.plataformavendas.plataformavendas;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
        private int id;
        private String nome;
        private String cpf;
        private LocalDate nascimento;
        private String email;
 }


