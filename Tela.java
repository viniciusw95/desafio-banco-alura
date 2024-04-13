import java.util.Random;
import java.util.Scanner;

public class Tela {

    public static final int CONSULTAR = 1;
    public static final int RECEBER_VALOR = 2;
    public static final int TRANSFERIR_VALOR = 3;
    public static final int FIM = 4;


    String menuPrincipal = """
             Operacoes:
             1- Consultar saldos
             2- Receber valor
             3- Transferir valor
             4- Sair
             """;

    public void mostrarOpcoesDoMenu() {
        System.out.println(menuPrincipal);
    }
    String menuRecebimento = """
            Opcoes de recebimento:
            1. Pix:
            2. Boleto:
            """;

    public int receberOpcao(String msg, int inicio, int fim) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(msg);
        int opcao = teclado.nextInt();
        while (opcao > fim || opcao < inicio) {
            System.out.println("Opção inválida. Tente novamente. ");
            System.out.println(msg);
            opcao = teclado.nextInt();
        }
        return opcao;
    }

    public void mostrarSaldoAtual(Conta cliente) {
        System.out.println(cliente.getSaldoAtual());
    }

    public void mostrarDadosIniciais(Conta cliente) {
        System.out.println(cliente.getDadosIniciais());
    }
    // RECEBIMENTO
    public static final int PIX = 1;
    public static final int BOLETO = 2;
    public static final int SAIR = 2;
    public void mostrarOpcoesDeRecebimento() {
        System.out.println(menuRecebimento);
    }

    public void gerarCodigoParaReceberValor(int opcao) throws Exception {
        Random gerador = new Random();
        switch (opcao) {
            case Tela.PIX -> {
                System.out.println("Código pix: " + Tela.PIX + gerador.nextInt(10000));
            }
            case Tela.BOLETO -> {
                System.out.println("Boleto: " + Tela.BOLETO + gerador.nextInt(10000));
            }
            default -> {
                throw new Exception("Opção para recebimento não reconhecida.");
            }
        }

    }

    // TRANSFERÊNCIA

    public int receberDestinario() {
        System.out.println("Conta destino: ");
        Scanner teclado = new Scanner(System.in);
        return teclado.nextInt();
    }

    public double receberValorParaTransferir() {
        System.out.println("Valor a transferir: R$ ");
        Scanner teclado = new Scanner(System.in);
        return teclado.nextDouble();

    }


    public String confirmarTransferencia() {
        System.out.println("Confirma a transferência? s/n: ");
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();

    }


}
