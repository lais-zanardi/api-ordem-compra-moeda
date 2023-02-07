package br.com.ada.moedas.compras.ordem;

public class CotacaoIndisponivelException extends Throwable {
    public CotacaoIndisponivelException(String message) {
        super(message);
    }
}
