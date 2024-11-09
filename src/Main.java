import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Cria e executa a interface gráfica na thread de eventos do Swing para garantir que seja thread-safe
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(); // Cria a janela principal do jogo
            gui.setVisible(true); // Define a janela como visível
        });
    }
}