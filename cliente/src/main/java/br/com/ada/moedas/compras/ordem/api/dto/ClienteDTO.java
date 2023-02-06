package br.com.ada.moedas.compras.ordem.api.dto;

import br.com.ada.moedas.compras.ordem.api.model.Cliente;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDTO {
    private final String cpf;
    private final String nome;

    public static ClienteDTO of(Cliente cliente) {
        return new ClienteDTO(cliente.getCpf(), cliente.getNome());
    }

    public Cliente toEntity() {
        Cliente entity = new Cliente();
        entity.setCpf(cpf);
        entity.setNome(nome);
        return entity;
    }

}