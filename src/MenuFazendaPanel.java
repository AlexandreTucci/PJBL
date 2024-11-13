import javax.swing.*;
import java.awt.*;

public class MenuFazendaPanel extends JPanel {

    public MenuFazendaPanel(GUI gui, Jogador jogador) {
        setLayout(new BorderLayout());
        
        // Define o fundo verde suave para o painel principal
        setBackground(new Color(204, 255, 204)); // Verde claro suave

        JLabel label = new JLabel("Bem-vindo, " + jogador.getNome(), SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);

        // Painel central para os botões
        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridLayout(3, 2, 10, 10)); // 3 linhas, 2 colunas, espaçamento de 10 pixels
        
        // Define o fundo verde suave para o painel dos botões
        botoesPanel.setBackground(new Color(204, 255, 204)); // Verde claro suave

        JButton salvarButton = new JButton("Salvar Jogo");
        salvarButton.setBackground(new Color(255, 255, 102)); // Amarelo suave
        salvarButton.setForeground(Color.BLACK); // Define o texto preto para o botão
        salvarButton.addActionListener(e -> {
            if (jogador != null) {
                Persistencia.salvarJogo(jogador, "jogoSalvo.dat");
                Persistencia.salvarJogoComoTexto(jogador, "jogoSalvo.txt");
                System.out.println("Jogo salvo com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum jogo em andamento para salvar.");
            }
        });
        botoesPanel.add(salvarButton);

        JButton novaFazendaButton = new JButton("Nova Fazenda");
        novaFazendaButton.setBackground(new Color(255, 255, 102)); // Amarelo suave
        novaFazendaButton.setForeground(Color.BLACK);
        novaFazendaButton.addActionListener(e -> {
            String nomeFazenda = JOptionPane.showInputDialog("Digite o nome da nova fazenda:");
            if (nomeFazenda == null) {
                return;
            }
            if (nomeFazenda.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O nome da fazenda não pode ser vazio.");
                return;
            }
            jogador.criarEAdicionarFazenda(nomeFazenda);
            JOptionPane.showMessageDialog(null, "Fazenda " + nomeFazenda + " criada com sucesso!");
        });
        botoesPanel.add(novaFazendaButton);

        JButton entrarFazendaButton = new JButton("Entrar na Fazenda");
        entrarFazendaButton.setBackground(new Color(255, 255, 102)); // Amarelo suave
        entrarFazendaButton.setForeground(Color.BLACK);
        entrarFazendaButton.addActionListener(e -> {
            String nomeFazenda = JOptionPane.showInputDialog("Digite o nome da fazenda para entrar:");
            if (nomeFazenda == null) {
                return;
            }
            if (nomeFazenda.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "O nome da fazenda não pode ser vazio.");
                return;
            }

            Fazenda fazenda = jogador.getFazendaByName(nomeFazenda);
            if (fazenda != null) {
                gui.abrirMenuInteragirFazenda(fazenda);
            } else {
                JOptionPane.showMessageDialog(null, "Fazenda não encontrada.");
            }
        });
        botoesPanel.add(entrarFazendaButton);

        JButton listarFazendasButton = new JButton("Listar Fazendas");
        listarFazendasButton.setBackground(new Color(255, 255, 102)); // Amarelo suave
        listarFazendasButton.setForeground(Color.BLACK);
        listarFazendasButton.addActionListener(e -> {
            StringBuilder fazendasList = new StringBuilder("Fazendas:\n");
            for (Fazenda fazenda : jogador.getFazendas()) {
                fazendasList.append(fazenda.getNome()).append("\n");
            }
            JOptionPane.showMessageDialog(null, fazendasList.toString());
        });
        botoesPanel.add(listarFazendasButton);

        JButton voltarMenuInicialButton = new JButton("Voltar para menu inicial");
        voltarMenuInicialButton.setBackground(new Color(255, 255, 102)); // Amarelo suave
        voltarMenuInicialButton.setForeground(Color.BLACK);
        voltarMenuInicialButton.addActionListener(e -> gui.voltarParaMenuInicial());
        botoesPanel.add(voltarMenuInicialButton);

        JButton sairButton = new JButton("Sair");
        sairButton.setBackground(new Color(255, 255, 102)); // Amarelo suave
        sairButton.setForeground(Color.BLACK);
        sairButton.addActionListener(e -> System.exit(0));
        botoesPanel.add(sairButton);

        add(botoesPanel, BorderLayout.CENTER);
    }
}
