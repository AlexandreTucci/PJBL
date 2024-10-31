import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicialPanel extends JPanel {

    public MenuInicialPanel(GUI gui) {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Bem-vindo ao Jogo de Fazenda!", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        JButton novoJogoButton = new JButton("Novo Jogo");
        JButton sairButton = new JButton("Sair");

        novoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome do jogador:");
                // Se o usuário clicar em "Cancelar", nomeFazenda será null. Apenas fecha o diálogo
                if (nome == null) {
                    return;
                }
                if (nome == null || nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O nome do jogador não pode ser vazio.");
                    return;
                }
                Jogador jogador = new Jogador(nome);
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
