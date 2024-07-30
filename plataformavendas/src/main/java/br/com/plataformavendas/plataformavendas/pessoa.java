package br.com.plataformavendas.plataformavendas;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class pessoa {



        private int id;
        private String nome;
        private String cpf;
        private LocalDate nascimento;
        private String email;

        // Construtor
        public pessoa(int id, String nome, String cpf, LocalDate nascimento, String email) {
            this.id = id;
            this.nome = nome;
            this.cpf = cpf;
            this.nascimento = nascimento;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", cpf='" + cpf + '\'' +
                    ", nascimento=" + nascimento +
                    ", email='" + email + '\'' +
                    '}';
        }
    }


