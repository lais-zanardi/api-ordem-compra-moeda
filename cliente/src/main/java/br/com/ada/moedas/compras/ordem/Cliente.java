package br.com.ada.moedas.compras.ordem;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Data
public class Cliente {
    @Id
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String estadoCivil;
    private String sexo;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public Cliente() {

    }
}