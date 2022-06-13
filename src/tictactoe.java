import javax.swing.*;

public class tictactoe {
    public static void main(String[] args) {
        pegarJogador(preencheJogador());
    }

    public static int[][] tabelaJogo() {
        int matriz[][] = new int[3][3];
        return matriz;
    }
// preencheJogador == Metodo que auto preenche o jogador(X || O)
    public static String[] preencheJogador() {
        String jogador[] = new String[9];
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                jogador[i] = "X";
            } else {
                jogador[i] = "O";
            }
        }
        return jogador;
    }

    public static void pegarJogador(String[] jogador) {
        for (int i = 0; i < 9; i++) {
            JOptionPane.showMessageDialog(null, "vez do jogador: " + jogador[i] + "");
        }
    }

    public static void pedirPosicao() {
        int linha[] = new int[9];
        int coluna[] = new int[9];
        for (int l = 0; l < 3; l++) {
            for (int c = 0; c < 3; c++) {
                linha[l] = Integer.parseInt(JOptionPane.showInputDialog("Insira a linha desejada"));
                coluna[c] = Integer.parseInt(JOptionPane.showInputDialog("Insira a coluna desejada"));
            }
        }
    }

}
