package br.com.ada.moedas.compras.ordem.api;

import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class ClienteApiClient {
    private final static String ENDPOINT = "http://localhost:8080/api/cliente/{id}";
    private final EurekaClient eurekaClient;
    private final RestTemplate restTemplate;

    public boolean existeCliente(String cpf) {
        return restTemplate.getForEntity(ENDPOINT.concat(cpf), String.class)
                .getStatusCode()
                .is2xxSuccessful();
    }
}
