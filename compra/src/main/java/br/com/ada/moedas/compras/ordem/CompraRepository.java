package br.com.ada.moedas.compras.ordem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {
}
