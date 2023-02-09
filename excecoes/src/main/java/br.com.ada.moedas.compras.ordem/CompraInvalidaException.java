package br.com.ada.moedas.compras.ordem;

public class CompraInvalidaException extends Throwable {
    public CompraInvalidaException(String message) {
        super(message);
    }
}
