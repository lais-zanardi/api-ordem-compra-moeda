package br.com.ada.moedas.compras.ordem;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/compra")
public class CompraController {
    private final CompraService service;
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody CompraDTO compra){
        if (!compra.getTipoMoeda().equalsIgnoreCase("USD") || !compra.getTipoMoeda().equalsIgnoreCase("EUR")){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Apenas trabalhamos com USD ou EUR");
        }
        if (compra.getNumeroAgência() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o número da agência");
        }
        if (compra.getValorMoeda() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado o valor a ser comprado da moeda");
        }
        return ResponseEntity.created(URI.create("/api/compra/" + compra.getId())).build();
    }
}
