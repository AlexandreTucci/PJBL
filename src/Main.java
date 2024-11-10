import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Cria e executa a interface gráfica na thread de eventos do Swing para garantir que seja thread-safe
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI(); // Cria a janela principal do jogo
            gui.setVisible(true); // Define a janela como visível

            File arquivoSalvo = new File("jogoSalvo.dat");
            if (arquivoSalvo.exists()) {
                int resposta = JOptionPane.showConfirmDialog(null, "Carregar jogo salvo?");
                if (resposta == JOptionPane.YES_OPTION) {
                    Jogador jogador = Persistencia.carregarJogo("jogoSalvo.dat");
                    if (jogador != null) {
                        gui.iniciarJogo(jogador);
                        return;  // Sai do construtor se o jogo salvo for carregado
                    }
                }
            }
        });


    }
}