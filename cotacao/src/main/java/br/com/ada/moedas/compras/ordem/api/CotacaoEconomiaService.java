package br.com.ada.moedas.compras.ordem.api;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CotacaoEconomiaService {
    private RestTemplate restTemplate;
    private final static String usd = "https://economia.awesomeapi.com.br/USD/";
    private final static String eur = "https://economia.awesomeapi.com.br/EUR/";

    public CotacaoEconomiaService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CotacaoRequestDTO getCotacaoEUR(){
        return restTemplate.getForObject(eur, CotacaoRequestDTO.class);
    }

    public CotacaoRequestDTO getCotacaoUSD(){
        return restTemplate.getForObject(usd, CotacaoRequestDTO.class);
    }
}
