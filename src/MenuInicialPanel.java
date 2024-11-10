import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicialPanel extends JPanel {
    private Jogador jogador;


    public MenuInicialPanel(GUI gui) {
        setLayout(new BorderLayout());


        // Verificação de jogo salvo
        JLabel label = new JLabel("Bem-vindo ao Jogo de Fazenda!", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JButton novoJogoButton = new JButton("Novo Jogo");
        JButton sairButton = new JButton("Sair");

        novoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome do jogador:");

                // Verifica se o usuário clicou em "Cancelar"
                if (nome == null) {
                    return;  // Operação cancelada pelo usuário
                }

                // Verifica se o nome está vazio ou em branco
                if (nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O nome do jogador não pode ser vazio.");
                    return;
                }

                // Se passar nas verificações, cria o jogador e inicia o jogo
                jogador = new Jogador(nome);
                gui.iniciarJogo(jogador);
            }
        });

        sairButton.addActionListener(e -> System.exit(0));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(novoJogoButton);
        buttonsPanel.add(sairButton);

        add(buttonsPanel, BorderLayout.CENTER);
    }
}
