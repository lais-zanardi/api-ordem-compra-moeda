package br.com.ada.moedas.compras.ordem.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

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
}
