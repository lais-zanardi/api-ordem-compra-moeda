package br.com.ada.moedas.compras.ordem.api;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

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