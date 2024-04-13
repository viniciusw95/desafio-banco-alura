import java.util.ArrayList;

public class Bytebank {

    public static void main(String[] args) throws Exception {

        Tela tela = new Tela();
        Conta cliente = new Conta(1111);

        cliente.inicializarDados();
        tela.mostrarDadosIniciais(cliente);

        int opcao = 0;
        while (opcao != 4) {
            tela.mostrarOpcoesDoMenu();
            opcao = tela.receberOpcao("Opções bancarias: ", Tela.CONSULTAR, Tela.FIM);
            switch (opcao) {
                case Tela.CONSULTAR -> {
                    tela.mostrarSaldoAtual(cliente);
                }
                case Tela.RECEBER_VALOR -> {
                    tela.mostrarOpcoesDeRecebimento();
                    opcao = tela.receberOpcao("Formas..: ", Tela.PIX, Tela.SAIR);
                    tela.gerarCodigoParaReceberValor(opcao);
                }
                case Tela.TRANSFERIR_VALOR -> {
                    int destino = tela.receberDestinario();
                    double valor = tela.receberValorParaTransferir();
                    String confirmacao = tela.confirmarTransferencia();
                    cliente.transferir(valor, destino);
                    tela.mostrarSaldoAtual(cliente);
                }
                default -> {
                    throw new Exception("Esta opção do menu principal não existe.");
                }
            }
        }
    }




}
