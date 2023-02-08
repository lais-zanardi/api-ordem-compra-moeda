package br.com.ada.moedas.compras.ordem;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClienteService {
    private final CrudRepository<Cliente, String> repository;

    public Optional<Cliente> getById(String cpf) {
        return repository.findById(cpf);
    }


    public void incluir(Cliente cliente) {
        repository.save(cliente);
    }
}
