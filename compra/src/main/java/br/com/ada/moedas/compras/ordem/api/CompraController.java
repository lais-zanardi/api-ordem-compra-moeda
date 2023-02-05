package br.com.ada.moedas.compras.ordem.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/api/compra")
public class CompraController {
    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody CompraDTO compra){
        if (compra == null || compra.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado uma compra válida");
        }
        return ResponseEntity.created(URI.create("/api/compra/" + compra.getId())).build();
    }
}
