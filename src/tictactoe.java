import javax.swing.*;

public class tictactoe {
    public static void main(String[] args) {

        pegarJogador();
    }

    public static void pegarJogador() {
        String jogador = "";
        for (int i = 0; i < 3; i++) {
            jogador = "X";
            JOptionPane.showMessageDialog(null, "vez do jogador: " + jogador + "");
            for (int j = 0; j < 3; j++) {
                jogador = "O";
            }
        }
    }

    public static int[][] tabelaJogo() {
        int matriz[][] = new int[3][3];
        return matriz;
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
