package Contas;
import java.math.BigDecimal;
import java.util.Scanner;


public class ContaCorrentePremium extends Conta {
    private BigDecimal limiteCredito;
    private Scanner scanner = new Scanner(System.in);

    public ContaCorrentePremium(String numeroConta, String nome, BigDecimal limiteCredito) {
        super(numeroConta, nome);
        this.limiteCredito = limiteCredito;
    }



    public void saque(String numeroConta) {
        Conta conta = getContas().get(numeroConta);
        if (conta != null) {
            System.out.println("Valor que quer sacar: ");
            BigDecimal valor = new BigDecimal(scanner.nextLine());
            BigDecimal saldoAtual = conta.getSaldo();
            if (valor.compareTo(BigDecimal.ZERO) > 0 &&
                valor.compareTo(saldoAtual.add(limiteCredito)) <= 0) {
                System.out.println("Data do Saque: ");
                String data = scanner.nextLine();
                if (valor.compareTo(saldoAtual) > 0){
                    conta.setSaldo(BigDecimal.ZERO);
                    limiteCredito = this.limiteCredito.subtract(valor);
                    conta.getTransacoes().add(new Transacao(data, valor, "Saque na conta"));
                    System.out.println("Saque realizado com sucesso!");
                }else{
                    conta.setSaldo(saldoAtual.subtract(valor));
                    conta.getTransacoes().add(new Transacao(data, valor.negate(), "Saque na conta"));
                    System.out.println("Saque realizado com sucesso!");
                }
            }else{
                System.out.println("Valor indisponível para saque ou valor inválido.");
            }
        } else {
            System.out.println("Conta inexistente!");
        }
    }

  public void imprimirExtrato() {
    super.imprimirExtrato();
    System.out.println("Limite de Crédito: " + limiteCredito);
    }
}


