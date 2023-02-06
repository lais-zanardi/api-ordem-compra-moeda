package br.com.ada.moedas.compras.ordem.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @PostMapping("/{cpf}")
    public ResponseEntity<Cliente> salvar(@PathVariable String cpf){
        if (cpf == null || cpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa válida");
        }
        String clearCpf = cpf.replaceAll("[\\.-]", "");
        if (clearCpf.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Não foi informada uma pessoa com CPF válido");
        }
        Cliente teste = new Cliente(clearCpf,"João");
        return ResponseEntity.ok(teste);
    }
}
