import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

public class tictactoe {
    private static String jogador = "";
    private static String ultimoJogador = "";
    private static String matriz[][] = new String[3][3];
    private static int resultado;

    public static void inicio() {
        int linha = 0, coluna = 0;
        criarTabela();
        do {
             do {
            jogador = JOptionPane.showInputDialog("Insira o jogador (X || O)").toUpperCase();
            } while (ultimoJogador.equals(jogador) || !jogador.equals("X") && !jogador.equals("O"));
            ultimoJogador = jogador;
            linha = Integer.parseInt(JOptionPane.showInputDialog("Informe a linha"));
            coluna = Integer.parseInt(JOptionPane.showInputDialog("Informe a coluna"));
            if (!validarJogada(linha, coluna)) {
                JOptionPane.showMessageDialog(null, "Jogada invalida");
                continue;
            }
            realizarJogada(linha, coluna);
            mostrarTabela();
            resultado = validarVencedor();
        } while (resultado == 2);
        mensagemResultado(resultado);
    }

    public static void mostrarTabela() {
        String[] colunas = {"", "", ""};
        JTable table = new JTable(matriz, colunas);
        table.setTableHeader(null);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.setDefaultRenderer(table.getColumnClass(i), dtcr);
        }
        JOptionPane.showMessageDialog(null, new JScrollPane(table));
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

    public static int validarVencedor() {
        int contadoraEmpate = 0;
        for (int l = 0; l < 3; l++) {
            int contadoraLinha = 0, contadoraColuna = 0;
            for (int c = 0; c < 3; c++) {
                if (matriz[l][c].equals(ultimoJogador)) {
                    contadoraLinha += 1;
                }
                if (contadoraLinha == 3) {
                    return 1;
                }
                if (matriz[c][l].equals(ultimoJogador)) {

                    contadoraColuna += 1;
                }
                if (contadoraColuna == 3) {
                    return 1;
                }
                if (matriz[0][0].equals(ultimoJogador) && matriz[1][1].equals(ultimoJogador) && matriz[2][2].equals(ultimoJogador)) {
                    return 1;
                }

                if (matriz[0][2].equals(ultimoJogador) && matriz[1][1].equals(ultimoJogador) && matriz[2][0].equals(ultimoJogador)) {
                    return 1;
                }
                if (!matriz[l][c].equals("")) {
                    contadoraEmpate += 1;
                    if (contadoraEmpate == 9) {
                        return 0;
                    }
                }
            }
        }
        return 2;
    }


    public static void mensagemResultado(int resultado) {
        if (resultado == 0) {
            JOptionPane.showMessageDialog(null, "VELHA");
        } else {
            JOptionPane.showMessageDialog(null, "O jogador: " + ultimoJogador + " Venceu!");
        }
    }

    public static void main(String[] args) {
        inicio();
    }
}