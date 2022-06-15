import javax.swing.*;

public class tictactoe {
    private static String jogador = "";
    private static String ultimoJogador = "";
    private static String matriz[][] = new String[3][3];
    private static boolean vencedor;

    public static void inicio() {
        int linha = 0, coluna = 0;
        criarTabela();
        do {
            do {
                jogador = JOptionPane.showInputDialog("Insira o jogador (X || O)");
            } while (ultimoJogador.equals(jogador));
            ultimoJogador = jogador;
            linha = Integer.parseInt(JOptionPane.showInputDialog("Informe a linha"));
            coluna = Integer.parseInt(JOptionPane.showInputDialog("Informe a coluna"));
            if (!validarJogada(linha, coluna)) {
                JOptionPane.showMessageDialog(null, "Jogada invalida");
            }
            realizarJogada(linha, coluna);
            vencedor = validarVencedor();
        } while (!vencedor);
        mensagemVencedor();
    }

    public static void realizarJogada(int linha, int coluna) {
        matriz[linha - 1][coluna - 1] = jogador;
    }

    public static void criarTabela() {
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                matriz[l][c] = "";
            }
        }
    }

    public static boolean validarJogada(int linha, int coluna) {
        try {
            if (linha < 1 || linha > 3 || coluna < 1 || coluna > 3) {
                return false;

            }
            if (!matriz[linha - 1][coluna - 1].equals("")) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean validarVencedor() {
        for (int l = 0; l < 3; l++) {
            int contadora = 0;
            for (int c = 0; c < 3; c++) {
                if (matriz[l][c].equals("X")) {
                    contadora += 1;
                    continue;
                }
                if (matriz[l][c].equals("O")) {
                    contadora += 1;
                }

            }
            if (contadora == 3) {
                return true;
            }
        }
        return false;
    }

    public static void mensagemVencedor() {
        JOptionPane.showMessageDialog(null, "O jogador: " + ultimoJogador + " Venceu!");
    }

    public static void main(String[] args) {
        inicio();
    }
}