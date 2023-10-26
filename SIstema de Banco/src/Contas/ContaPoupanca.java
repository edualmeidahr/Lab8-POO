package Contas;
import java.util.Scanner;
// import java.util.HashMap;
// import java.util.Map;

public class ContaPoupanca extends Conta {
    Scanner scanner = new Scanner(System.in);
    private String dataAniversario;
    // private static Map<String, Conta> contas = new HashMap<>();

    public ContaPoupanca(String numeroConta, String nome, String dataAniversario) {
        super(numeroConta, nome);
        this.dataAniversario = dataAniversario;
    }



    public void imprimirExtrato() {
        super.imprimirExtrato();
        System.out.println("Data de Aniversário: " + dataAniversario);
    }
}
