package br.com.ada.moedas.compras.ordem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CompraService {
    private final CrudRepository<Compra, Long> compraRepository;

    public Optional<Compra> getById (Long id){
        return compraRepository.findById(id);
    }
    public void incluir (Compra compra){
        compraRepository.save(compra);
    }
}
