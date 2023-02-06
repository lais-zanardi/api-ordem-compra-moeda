package br.com.ada.moedas.compras.ordem.api.service;

import br.com.ada.moedas.compras.ordem.api.model.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final CrudRepository<Cliente, Long> clienteRepository;

    public Optional<Cliente> getById(Long id) {
        return clienteRepository.findById(id);
    }


    public void incluir(Cliente cliente) {
        clienteRepository.save(cliente);
    }
}
