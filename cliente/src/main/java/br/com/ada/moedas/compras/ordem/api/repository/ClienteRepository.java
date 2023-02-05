package br.com.ada.moedas.compras.ordem.api.repository;

import br.com.ada.moedas.compras.ordem.api.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
}
