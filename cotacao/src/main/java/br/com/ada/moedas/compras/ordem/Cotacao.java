package br.com.ada.moedas.compras.ordem;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cotacao {
    private BigDecimal valorCotacao;
    private String tipoMoeda;
}
