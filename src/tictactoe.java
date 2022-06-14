import javax.swing.*;
import java.util.Objects;

public class tictactoe {
    private static String jogador = "";
    private static String ultimaJogada;
    private static String matriz[][] = new String[3][3];

    public static void inicio() {
        int linha = 0, coluna;
        jogador = JOptionPane.showInputDialog("Insira o jogador (X || O)");
        ultimaJogada = jogador;

        linha = Integer.parseInt(JOptionPane.showInputDialog("Informe a linha"));
        coluna = Integer.parseInt(JOptionPane.showInputDialog("Informe a coluna"));
        if (!validarJogada(linha, coluna)) {
            JOptionPane.showMessageDialog(null, "Jogada invalida");
        }
    }

    public static boolean validarJogador() {
        if (Objects.equals(jogador, ultimaJogada)) {
            return false;
        }
        return true;
    }

    public static boolean validarJogada(int linha, int coluna) {
        try {
            if (linha < 1 || linha > 3 || coluna < 1 || coluna > 3) {
                return false;

            }
            if (matriz[linha][coluna] != null) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

//    public static void pegarLinha(String[] jogador) {
//        for (int i = 0; i < 9; i++) {
//            JOptionPane.showInputDialog("vez do jogador: " + jogador[i] + " | Insira a linha");
//        }
//    }
//
//    public static void pegarColuna(String[] jogador) {
//        for (int i = 0; i < 9; i++) {
//            JOptionPane.showInputDialog("vez do jogador: " + jogador[i] + " | Insira a coluna");
//        }
//    }

    public static void main(String[] args) {
        inicio();
    }
}