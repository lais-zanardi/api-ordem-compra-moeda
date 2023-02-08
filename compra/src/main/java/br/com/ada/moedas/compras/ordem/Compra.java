package br.com.ada.moedas.compras.ordem;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
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
