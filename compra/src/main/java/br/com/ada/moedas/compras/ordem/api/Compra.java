package br.com.ada.moedas.compras.ordem.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Compra {

    @Id
    private Long id;
    private String tipoMoeda;
    private BigDecimal valorMoeda;
    private Integer numeroAgência;
    private String cliente;
    private String cotacao;

}
