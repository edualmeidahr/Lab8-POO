import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import Contas.*;

public class App {
    private static Map<String, Conta> contas = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("MENU: ");
            System.out.println("1) Criar Conta Corrente");
            System.out.println("2) Criar Conta Poupança");
            System.out.println("3) Criar Conta Corrente Premium");
            System.out.println("4) Criar Conta Investimento");
            System.out.println("5) Depósito");
            System.out.println("6) Saque");
            System.out.println("7) Imprimir Extrato");
            System.out.println("8) Sair");
            int op = scanner.nextInt();
            scanner.nextLine();

            switch (op) {
                case 1:
                    criarContaCorrente();
                    break;
                case 2:
                    criarContaPoupanca();
                    break;
                case 3:
                    criarContaCorrentePremium();
                    break;
                case 4:
                    criarContaInvestimento();
                    break;
                case 5:
                    realizarDeposito();
                    break;
                case 6:
                    realizarSaque();
                    break;
                case 7:
                    imprimirExtrato();
                    break;
                case 8:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida!");
                    break;
            }
        }
    }

    private static void criarContaCorrente() {
        System.out.println("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.println("Nome do titular da conta: ");
        String nome = scanner.nextLine();
        for (String numeroContaAux : contas.keySet()) {
            if (numeroContaAux.equals(numeroConta)) {
                System.out.println("Conta já existente!");
                return;
            }
        }
        contas.putIfAbsent(numeroConta, new Conta(numeroConta, nome));
        System.out.println("Conta Corrente cadastrada com sucesso!");
    }

    private static void criarContaPoupanca() {
        System.out.println("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.println("Nome do titular da conta: ");
        String nome = scanner.nextLine();
        System.out.println("Data de aniversário da conta:");
        String dataAniversario = scanner.nextLine();
        for (String numeroContaAux : contas.keySet()) {
            if (numeroContaAux.equals(numeroConta)) {
                System.out.println("Conta já existente!");
                return;
            }
        }
        contas.putIfAbsent(numeroConta, new ContaPoupanca(numeroConta, nome, dataAniversario));
        System.out.println("Conta Poupança cadastrada com sucesso!");
    }

    private static void criarContaCorrentePremium() {
        System.out.println("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.println("Nome do titular da conta: ");
        String nome = scanner.nextLine();
        System.out.println("Limite de crédito:");
        BigDecimal limiteCredito = new BigDecimal(scanner.nextLine());
        for (String numeroContaAux : contas.keySet()) {
            if (numeroContaAux.equals(numeroConta)) {
                System.out.println("Conta já existente!");
                return;
            }
        }
        contas.putIfAbsent(numeroConta, new ContaCorrentePremium(numeroConta, nome, limiteCredito));
        System.out.println("Conta Corrente Premium cadastrada com sucesso!");

    }

    private static void criarContaInvestimento() {
        System.out.println("Número da conta: ");
        String numeroConta = scanner.nextLine();
        System.out.println("Nome do titular da conta: ");
        String nome = scanner.nextLine();
        System.out.println("Taxa de retorno anual: ");
        BigDecimal taxaRetornoAnual = new BigDecimal(scanner.nextLine());
        for (String numeroContaAux : contas.keySet()) {
            if (numeroContaAux.equals(numeroConta)) {
                System.out.println("Conta já existente!");
                return;
            }
        }
        contas.putIfAbsent(numeroConta, new ContaInvestimento(numeroConta, nome, taxaRetornoAnual));
        System.out.println("Conta Investimento cadastrada com sucesso!");
    }

    private static void realizarDeposito() {
        System.out.println("Número da Conta: ");
        String numeroConta = scanner.nextLine();
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            conta.deposito(numeroConta);
        } else {
            System.out.println("Conta inexistente!");
        }
    }

    private static void realizarSaque() {
        System.out.println("Número da Conta: ");
        String numeroConta = scanner.nextLine();
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            conta.saque(numeroConta);
        } else {
            System.out.println("Conta inexistente!");
        }
    }

    private static void imprimirExtrato() {
        System.out.println("Número da Conta: ");
        String numeroConta = scanner.nextLine();
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            conta.imprimirExtrato();
        } else {
            System.out.println("Conta inexistente!");
        }
    }
}
