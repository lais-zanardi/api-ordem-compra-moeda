package br.com.ada.moedas.compras.ordem.api;

import br.com.ada.moedas.compras.ordem.CotacaoIndisponivelException;
import br.com.ada.moedas.compras.ordem.EntidadeDuplicadaException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

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

    public void incluir(Compra entity) throws EntidadeDuplicadaException, CotacaoIndisponivelException, CompraInvalidaException {

        // Confirma se compra não está duplicada (consulta repository e retorna exception caso esteja)
        if(repository.existsById(entity.getId())) {
            throw new EntidadeDuplicadaException();
        }

        //Confirma se o cliente existe (consultar API Cliente)
        try {
            if(!clienteApiClient.existeCliente(entity.getCliente())) {
                throw new CompraInvalidaException("Cliente não localizado");
            }
        } catch (RestClientException e) {
            throw new CompraInvalidaException("API Cliente indisponível!");
        }

        // Confirma se a moeda consultada é USD ou EUR (consultar API Cotação)
        try {
            if(!cotacaoApiClient.cotacaoDisponivel(entity.getTipoMoeda())) {
                throw new CotacaoIndisponivelException("Moeda inválida");
            }
        } catch (RestClientException e) {
            throw new CompraInvalidaException("API Cotação indisponível!");
        }
        repository.save(entity);
    }


    /**
     * Para realizar a compra de moedas é necessário:

     * -
     * -
     */




}
