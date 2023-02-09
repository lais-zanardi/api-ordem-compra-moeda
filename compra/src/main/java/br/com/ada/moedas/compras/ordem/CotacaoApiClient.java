package br.com.ada.moedas.compras.ordem;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class CotacaoApiClient {
    private final static String ENDPOINT = "http://{host}:{port}/api/cotacao/{moeda}";
    private final EurekaClient eurekaClient;
    private final RestTemplate restTemplate;

    public boolean cotacaoDisponivel(String moeda) {
        InstanceInfo apiInstanceInfo = eurekaClient
                .getApplication("rooms-cotacao")
                .getInstances()
                .stream()
                .findAny()
                .orElseThrow(() -> new RemoteAccessException("Cotacao API Indisponível"));

        return restTemplate
                .getForEntity(ENDPOINT, String.class, apiInstanceInfo.getHostName(), apiInstanceInfo.getPort(), moeda)
                .getStatusCode()
                .is2xxSuccessful();
    }
}
