import java.util.Scanner;

public class Conta {
    private String nome;
    private int numero;
    private String tipoConta;
    private double saldoInicial;
    private double saldoAtual;
    Conta(int numero) {
        this.numero = numero;
        inicializarDados();
    }

    public void inicializarDados() {
        nome = "Vinícius";
        tipoConta = "Essencial";
        saldoInicial = 1000.0;
        saldoAtual = 1000.0;
    }

    public String getDadosIniciais() {
        return String.format("""
                Nome: %s
                Tipo da conta: %s
                Saldo inicial: %f
                %n""", nome, tipoConta, saldoInicial);
    }
    public String getSaldoAtual() {
        return String.format("""
                Nome: %s
                Saldo atual: %f
                %n""", nome, saldoAtual);
    }


    public void transferir(double valor, int destino) {

        String confirmacao = new Scanner(System.in).nextLine();
        if (confirmacao.equals("s") && this.saldoAtual >= valor) {
            saldoAtual -= valor;
            System.out.println("Conta " + destino + " recebeu R$ " + valor);
        }
        else {
            System.out.println("Nenhum valor foi transferido.");
        }
    }
}
