package br.com.ada.moedas.compras.ordem.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService service;
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

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable String cpf) {
        if (cpf == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF não informado");
        }
        Cliente entity = service.getById(cpf)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi localizado um cliente com este CPF"));
        return ResponseEntity.ok(ClienteDTO.of(entity));
    }
}

