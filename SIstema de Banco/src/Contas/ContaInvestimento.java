package Contas;
import java.util.Scanner;

import java.math.BigDecimal;

public class ContaInvestimento extends Conta {
    Scanner scanner = new Scanner(System.in);
    private BigDecimal taxaRetornoAnual;

    public ContaInvestimento(String numeroConta, String nome, BigDecimal taxaRetornoAnual) {
        super(numeroConta, nome);
        this.taxaRetornoAnual = taxaRetornoAnual;
    }


    public void imprimirExtrato() {
        super.imprimirExtrato();
        System.out.println("Taxa de Retorno Anual: " + taxaRetornoAnual);
    }
}
