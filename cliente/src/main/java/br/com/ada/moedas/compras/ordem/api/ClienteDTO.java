package br.com.ada.moedas.compras.ordem.api;

import lombok.Data;

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