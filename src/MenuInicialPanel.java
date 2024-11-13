import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicialPanel extends JPanel {
    private Jogador jogador;

    public MenuInicialPanel(GUI gui) {
        setLayout(new BorderLayout());

        // Define o fundo verde suave para o painel principal
        setBackground(new Color(204, 255, 204)); // Verde claro suave

        // Verificação de jogo salvo
        JLabel label = new JLabel("Bem-vindo ao Jogo de Fazenda!", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 24));
        label.setForeground(Color.BLACK);
        add(label, BorderLayout.NORTH);

        JButton novoJogoButton = new JButton("Novo Jogo");
        JButton sairButton = new JButton("Sair");

        // Define o fundo vermelho mais forte para os botões
        novoJogoButton.setBackground(new Color(144, 238, 144)); // Vermelho mais intenso
        novoJogoButton.setForeground(Color.BLACK); // Texto branco para contraste
        sairButton.setBackground(new Color(255, 160, 122));
        sairButton.setForeground(Color.BLACK);

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
        buttonsPanel.setBackground(new Color(204, 255, 204)); // Fundo verde claro suave
        buttonsPanel.add(novoJogoButton);
        buttonsPanel.add(sairButton);

        add(buttonsPanel, BorderLayout.CENTER);

        // Adiciona o GIF abaixo dos botões
        ImageIcon gifIcon = new ImageIcon("../PJBL/GIF_tratorzin.gif"); // Substitua pelo caminho correto do seu GIF
        JLabel gifLabel = new JLabel(gifIcon);
        add(gifLabel, BorderLayout.SOUTH);
    }
}
