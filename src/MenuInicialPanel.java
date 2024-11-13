import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MenuInicialPanel extends JPanel {
    private Jogador jogador;
    private ImageIcon backgroundGif;

    public MenuInicialPanel(GUI gui) {
        setLayout(new BorderLayout());

        // Array de caminhos para GIFs
        String[] gifPaths = {
            "../PJBL/GIFs/GIF_tratorzin.gif",
            "../PJBL/GIFs/GIF_galinhaandando.gif",
            "../PJBL/GIFs/GIF_pigFungando.gif",
            "../PJBL/GIFs/GIF_vacaFungando.gif",
            "../PJBL/GIFs/GIF_vaquinhasCoracao.gif"
        };

        // Seleciona um GIF aleatório
        Random random = new Random();
        int randomIndex = random.nextInt(gifPaths.length);
        backgroundGif = new ImageIcon(gifPaths[randomIndex]);

        // Define o fundo transparente para sobreposição dos componentes
        setOpaque(false);

        // Verificação de jogo salvo
        JLabel label = new JLabel("Bem-vindo ao Jogo de Fazenda!", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 24));
        label.setForeground(Color.BLACK);
        add(label, BorderLayout.NORTH);

        JButton novoJogoButton = new JButton("Novo Jogo");
        JButton sairButton = new JButton("Sair");

        novoJogoButton.setBackground(new Color(144, 238, 144)); // Verde claro
        novoJogoButton.setForeground(Color.BLACK);
        sairButton.setBackground(new Color(255, 160, 122)); // Laranja claro
        sairButton.setForeground(Color.BLACK);

        novoJogoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Digite o nome do jogador:");

                if (nome == null || nome.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O nome do jogador não pode ser vazio.");
                    return;
                }

                jogador = new Jogador(nome);
                gui.iniciarJogo(jogador);
            }
        });

        sairButton.addActionListener(e -> System.exit(0));

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(new Color(0, 0, 0, 0)); // Fundo transparente para ver o GIF
        buttonsPanel.add(novoJogoButton);
        buttonsPanel.add(sairButton);

        add(buttonsPanel, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Desenha o GIF de fundo
        if (backgroundGif != null) {
            g.drawImage(backgroundGif.getImage(), 0, 0, getWidth(), getHeight(), this);
        }
    }
}
