package br.com.ada.moedas.compras.ordem.api;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class ClienteApiClient {
    private final static String ENDPOINT = "http://{host}:{port}/api/cliente/{cpf}";
    private final EurekaClient eurekaClient;
    private final RestTemplate restTemplate;

    public boolean existeCliente(String cpf) {
        InstanceInfo apiInstanceInfo = eurekaClient
                .getApplication("rooms-cliente")
                .getInstances()
                .stream()
                .findAny()
                .orElseThrow(() -> new RemoteAccessException("Cliente API Indisponível"));

        return restTemplate
                .getForEntity(ENDPOINT, String.class, apiInstanceInfo.getHostName(), apiInstanceInfo.getPort(), cpf)
                .getStatusCode()
                .is2xxSuccessful();
    }
}
