package br.com.ada.moedas.compras.ordem.api;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cotacao {
    private BigDecimal valorCotacao;
    private String tipoMoeda;
}
