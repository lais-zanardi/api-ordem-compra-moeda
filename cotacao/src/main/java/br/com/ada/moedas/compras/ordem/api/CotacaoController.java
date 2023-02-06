package br.com.ada.moedas.compras.ordem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cotacao")
public class CotacaoController {
    private CotacaoEconomiaService cotacaoEconomiaService;
    @GetMapping ("USD")
    public ResponseEntity<CotacaoRequestDTO> dolar(@PathVariable String moeda){
        if (moeda.isBlank() || moeda == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado a moeda!");
        }
        return ResponseEntity.ok(cotacaoEconomiaService.getCotacaoUSD());
    }
    @GetMapping ("EUR")
    public ResponseEntity<CotacaoRequestDTO> euro(@PathVariable String moeda){
        if (moeda.isBlank() || moeda == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informado a moeda!");
        }
        return ResponseEntity.ok(cotacaoEconomiaService.getCotacaoEUR());
    }
}
