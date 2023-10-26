package Contas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Conta {
    private static Map<String, Conta> contas = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private String numeroConta;
    private String nome;
    private BigDecimal saldo;
    private List<Transacao> transacoes;

    public Conta(String numeroConta, String nome) {
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldo = BigDecimal.ZERO;
        this.transacoes = new ArrayList<>();
        contas.put(numeroConta, this);
    }

   public static Map<String, Conta> getContas() {
        return contas;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }
    
    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }


    public String getNumeroConta() {
        return numeroConta;
    }



    public void deposito(String numeroConta) {
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            System.out.println("Valor que quer depositar: ");
            BigDecimal valor = new BigDecimal(scanner.nextLine());
            if (valor.compareTo(BigDecimal.ZERO) > 0) {
                System.out.println("Data do Depósito:");
                String data = scanner.nextLine();
                conta.saldo = conta.saldo.add(valor);
                conta.transacoes.add(new Transacao(data, valor, "Depósito na conta"));
                System.out.println("Depósito realizado com sucesso!");
            } else {
                System.out.println("O valor do depósito deve ser maior que zero.");
            }
        }else {
            System.out.println("Conta inexistente!");
        }
    }

    public void saque(String numeroConta) {
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            System.out.println("Valor que quer sacar: ");
            BigDecimal valor = new BigDecimal(scanner.nextLine());
            if (valor.compareTo(BigDecimal.ZERO) > 0 && valor.compareTo(conta.saldo) <= 0) {
                System.out.println("Data do Saque: ");
                String data = scanner.nextLine();
                conta.saldo = conta.saldo.subtract(valor);
                conta.transacoes.add(new Transacao(data, valor.negate(), "Saque na conta"));
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Valor indisponível para saque ou valor inválido.");
            }
        } else {
            System.out.println("Conta inexistente!");
        }
    }

    public void imprimirExtrato() {
        System.out.println("-------------- EXTRATO --------------");
        System.out.println("Número da conta: " + numeroConta);
        System.out.println("Nome do proprietário da conta: " + nome);
        System.out.println("\nTRANSAÇÕES:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
        System.out.println("Saldo: " + saldo);
    }
}