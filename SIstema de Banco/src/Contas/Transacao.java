package Contas;

import java.math.BigDecimal;

public class Transacao {
    private String data;
    private BigDecimal valor;
    private String descricao;

    public Transacao(String data, BigDecimal valor, String descricao) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    public String toString() {
        return "Data: " + data + "\nValor: " + valor + "\nDescrição: " + descricao + "\n----------------------";
    }
}
