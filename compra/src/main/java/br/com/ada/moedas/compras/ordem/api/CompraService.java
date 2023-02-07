package br.com.ada.moedas.compras.ordem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompraService {
    private final CrudRepository<Compra, Long> repository;
    private final ClienteApiClient clienteApiClient;
    private final CotacaoApiClient cotacaoApiClient;

    public Optional<Compra> getById(Long id) {
        return repository.findById(id);
    }

    public void incluir(Compra entity) {
        if(repository.existsById(entity.getId())) {
            throw new EntidadeDuplicadaException();
        }
        repository.save(compra);
    }


    /**
     * Para realizar a compra de moedas é necessário:
     * - Confirmar que compra não está duplicada (consulta repository e retorna exception caso esteja)
     * - Confirmar que o cliente existe (consultar API Cliente)
     * - Confirmar que a moeda consultada é USD ou EUR (consultar API Cotação)
     */




}
