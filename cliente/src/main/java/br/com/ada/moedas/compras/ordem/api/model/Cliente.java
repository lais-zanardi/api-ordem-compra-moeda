package br.com.ada.moedas.compras.ordem.api.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name="CPF")
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