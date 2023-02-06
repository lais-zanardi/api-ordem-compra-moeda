package br.com.ada.moedas.compras.ordem.api;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CotacaoRequestDTO {
    private BigDecimal valorCotacao;
    private String tipoMoeda;

    public static CotacaoRequestDTO of(Cotacao cotacao){
        CotacaoRequestDTO cotacaoRequestDTO = new CotacaoRequestDTO();
        cotacaoRequestDTO.setValorCotacao(cotacao.getValorCotacao());
        cotacaoRequestDTO.setTipoMoeda(cotacao.getTipoMoeda());
        return cotacaoRequestDTO;
    }
    public Cotacao toEntity(){
        Cotacao cotacao = new Cotacao();
        cotacao.setValorCotacao(valorCotacao);
        cotacao.setTipoMoeda(tipoMoeda);
        return cotacao;
    }
}
